package ru.olenevody.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.olenevody.dao.TeamDAO;
import ru.olenevody.model.Team;

import java.util.List;

@Repository
public class TeamDAOImpl implements TeamDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    private Session getCurrentSession() {
        try {
            return this.sessionFactory.getCurrentSession();
        } catch (Exception e) {
            return this.sessionFactory.openSession();
        }
    }

    @Override
    public List<Team> getTeams() {
        Session session = getCurrentSession();
        List<Team> teamList = session.createQuery("FROM Team").list();
        session.close();
        return teamList;
    }

    @Override
    public Team getTeamByPin(String pin) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from Team where pin = :pin");
        query.setParameter("pin", pin);
        List<Team> teams = query.list();
        session.close();

        if (teams.size() == 0) {
            return null;
        } else {
            return teams.get(0);
        }
    }

}
