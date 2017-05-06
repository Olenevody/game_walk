package ru.olenevody.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.olenevody.Code;
import ru.olenevody.model.Level;
import ru.olenevody.model.Levels;
import ru.olenevody.model.LogLevelEntity;
import ru.olenevody.model.Team;

import java.util.TimerTask;

@Service
public class GameService {

    @Autowired
    Levels levels;

    @Autowired
    LogLevelService logLevelService;

    public GameService() {
    }

    public Game startNewGame(String pin, Team team) {
        Game game = new Game(pin, team, levels.getLevel(0));
        startTimer(game);
        return game;
    }

    public int getLevelsCount() {
        return levels.getLevelsCount();
    }

    public synchronized Code.EnterCodeResult enterCode(Game game, String code) {
        Code.EnterCodeResult ecr = game.enterCode(code);
        if (game.allCodesDone()) {
            game.addDoneLevel(game.getLevel());
            setNextLevel(game);
        }
        return ecr;
    }

    private synchronized Level getNextLevel(Level curLevel) {
        return levels.getNextLevel(curLevel);
    }

    private synchronized void setNextLevel(Game game) {
        Level nextLevel = getNextLevel(game.getLevel());
        if (nextLevel == null) {
            game.setStatus(Game.Status.FINISHED);
        } else {
            game.setLevel(nextLevel);
            game.resetTimeOnLevel();
        }
    }

    private void startTimer(Game game) {
        game.getTimer().schedule(new GameTimerTask(game), 0, 1000);
    }

    class GameTimerTask extends TimerTask {

        Game game;

        private GameTimerTask(Game game) {
            this.game = game;
        }

        @Override
        public void run() {
            game.incTimeOnLevel();
            Level level = game.getLevel();
            if (!level.allCodesDone()&& level.getDuration() <= game.getTimeOnLevel()) {
                if (game.getStatus() != Game.Status.FINISHED) {
                    ((Runnable) () -> logLevelService.log(game, game.getLevel(), false)).run();
                }
                setNextLevel(game);
                if (game.getStatus() == Game.Status.FINISHED) {
                    game.getTimer().cancel();
                }
            }
        }
    }

}
