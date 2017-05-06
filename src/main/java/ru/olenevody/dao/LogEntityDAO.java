package ru.olenevody.dao;

import ru.olenevody.model.LogEntity;
import ru.olenevody.model.Team;

import java.util.List;

public interface LogEntityDAO {

    void saveLogEntity(LogEntity logEntity);

    List<LogEntity> list();

    List<LogEntity> listByTeam(Team team);

}
