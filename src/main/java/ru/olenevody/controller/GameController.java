package ru.olenevody.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.olenevody.Code;
import ru.olenevody.dao.impl.TeamDAOImpl;
import ru.olenevody.game.Game;
import ru.olenevody.game.GameService;
import ru.olenevody.game.LogLevelService;
import ru.olenevody.game.LogService;
import ru.olenevody.model.Level;
import ru.olenevody.model.Team;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private LogService logService;

    @Autowired
    private LogLevelService logLevelService;

    @Autowired
    private TeamDAOImpl teamDAO;

    private Map<String, Game> games = new HashMap<>();

    public GameController() {
    }

    @PostConstruct
    public void init() {
        List<Team> teams = logLevelService.getFinishedTeams(gameService.getLevelsCount());
        for (Team team : teams) {
            Game game = new Game(team.getPin(), team, null);
            game.setStatus(Game.Status.FINISHED);
            games.put(team.getPin(), game);
        }
    }

    @RequestMapping(value = "/{pin}", method = RequestMethod.GET)
    public String game(@PathVariable String pin, Model model) {
        Game game = games.get(pin);
        if (game == null) {
            model.addAttribute("error", "Игра не запущена");
            return "errorPage";
        } else {
            model.addAttribute("game", game);
            if (game.getStatus() == Game.Status.FINISHED) {
                model.addAttribute("doneLevels", logLevelService.getDoneLevels(game.getTeam()));
            } else {
                model.addAttribute("timer", game.getLevel().getDuration() - game.getTimeOnLevel());
            }
            return "game";
        }
    }

    @RequestMapping(value = "/checkUpdate/{pin}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String checkUpdate(@PathVariable String pin) {
        Game game = games.get(pin);
        if (game == null) {
            return "false";
        }
        if (game.getStatus() == Game.Status.FINISHED) {
            return "true";
        }
        if (game.getLevel().getDuration() <= game.getTimeOnLevel()) {
            return "false";
        }
        return "true";
    }

    @RequestMapping(value = "/startGame", method = RequestMethod.POST)
    public String startGame(@RequestParam String pin, Model model) {
        Game game = games.get(pin);
        if (game == null) {
            Team team = teamDAO.getTeamByPin(pin);
            if (team == null) {
                model.addAttribute("error", "Неверный пин");
                return "errorPage";
            }
            games.put(pin, gameService.startNewGame(pin, team));
        }
        return "redirect:/" + pin;
    }

    @RequestMapping(value = "/{pin}", method = RequestMethod.POST)
    public String enterCode(@PathVariable String pin, @RequestParam String code, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        Game game = games.get(pin);
        if (game == null) {
            return "redirect:/errorPage";
        } else {
            try {
                code = URLDecoder.decode(URLEncoder.encode(code, "ISO-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                redirectAttributes.addFlashAttribute("error", e.toString());
                return "redirect:/errorPage";
            }

            synchronized (game) {

                Level level = game.getLevel();
                Code.EnterCodeResult enterCodeResult = gameService.enterCode(game, code);
                String ip = request.getRemoteAddr();
                String userAgent = request.getHeader("user-agent");
                logService.log(ip, userAgent, game, level, code, enterCodeResult);
                if ((enterCodeResult == Code.EnterCodeResult.DONE && level != game.getLevel())
                        || game.getStatus() == Game.Status.FINISHED) {
                    logLevelService.log(game, level, true);
                }
                redirectAttributes.addFlashAttribute("enterCodeResult", enterCodeResult);
                return "redirect:/" + pin;

            }
        }

    }

}
