package ru.olenevody.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.olenevody.Code;
import ru.olenevody.dao.LogEntityDAO;
import ru.olenevody.model.Level;
import ru.olenevody.model.LogEntity;
import ru.olenevody.model.Team;

import java.util.Date;
import java.util.List;

@Service
public class LogService {

    @Autowired
    LogEntityDAO logger;

    public LogService() {
    }

    public void log(String ip, String userAgent, Game game, Level level, String code, Code.EnterCodeResult enterCodeResult) {
        LogEntity logEntity = new LogEntity();
        logEntity.setIp(ip);
        logEntity.setUserAgent(userAgent);
        logEntity.setTeam(game.getTeam());
        logEntity.setLevel(level.getNumber());
        logEntity.setDate(new Date());
        logEntity.setStartLevelDate(level.getStartDate());
        logEntity.setCode(code);
        logEntity.setMatched(enterCodeResult == Code.EnterCodeResult.DONE);
        logger.saveLogEntity(logEntity);
    }

    public List<LogEntity> list() {
        return logger.list();
    }

    public List<LogEntity> listByTeam(Team team) {
        return logger.listByTeam(team);
    }

}
