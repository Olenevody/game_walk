package ru.olenevody.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.olenevody.dao.LogLevelEntityDAO;
import ru.olenevody.model.Level;
import ru.olenevody.model.LogLevelEntity;
import ru.olenevody.model.Team;

import java.util.Date;
import java.util.List;

@Service
public class LogLevelService {

    @Autowired
    LogLevelEntityDAO logger;

    public LogLevelService() {
    }

    public void log(Game game, Level level, boolean done) {
        LogLevelEntity logLevelEntity = new LogLevelEntity();
        logLevelEntity.setTeam(game.getTeam());
        logLevelEntity.setLevel(level.getNumber());
        logLevelEntity.setDate(new Date());
        logLevelEntity.setDone(done);
        logger.saveLogLevelEntity(logLevelEntity);
    }

    public List<LogLevelEntity> getDoneLevels(Team team) {
        return logger.getDoneLevels(team);
    }

    public List<Team> getFinishedTeams(int levelCount) {
        return logger.getFinishedTeams(levelCount);
    }

}
