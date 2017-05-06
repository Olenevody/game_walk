package ru.olenevody.dao;

import ru.olenevody.model.Team;

import java.util.List;

public interface TeamDAO {

    List<Team> getTeams();

    Team getTeamByPin(String pin);

}
