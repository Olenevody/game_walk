package ru.olenevody.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.olenevody.dao.LogLevelEntityDAO;
import ru.olenevody.model.LogLevelEntity;
import ru.olenevody.model.Team;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LogLevelEntityDAOImpl implements LogLevelEntityDAO {

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
    public void saveLogLevelEntity(LogLevelEntity logLevelEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.save(logLevelEntity);
        transaction.commit();
        session.close();
    }

    @Override
    public List getDoneLevels(Team team) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from LogLevelEntity where team_id = :team and done = :done");
        query.setParameter("team", team);
        query.setBoolean("done", true);
        List<LogLevelEntity> list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<Team> getFinishedTeams(int levelCount) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from LogLevelEntity where level = :levelCount");
        query.setParameter("levelCount", levelCount);
        List<LogLevelEntity> list = query.list();
        session.close();
        List<Team> teams = new ArrayList<>();
        for (LogLevelEntity logLevelEntity : list) {
            Team team = logLevelEntity.getTeam();
            if (!teams.contains(team)) {
                teams.add(team);
            }
        }
        return teams;
    }
}
