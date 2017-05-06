package ru.olenevody.dao;

import ru.olenevody.model.LogLevelEntity;
import ru.olenevody.model.Team;

import java.util.List;

public interface LogLevelEntityDAO {

    void saveLogLevelEntity(LogLevelEntity logLevelEntity);

    List getDoneLevels(Team team);

    List getFinishedTeams(int levelCount);

}
