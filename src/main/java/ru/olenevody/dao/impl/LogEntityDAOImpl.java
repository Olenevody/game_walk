package ru.olenevody.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.olenevody.dao.LogEntityDAO;
import ru.olenevody.model.LogEntity;
import ru.olenevody.model.Team;

import java.util.List;

@Repository
public class LogEntityDAOImpl implements LogEntityDAO {

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
    public void saveLogEntity(LogEntity logEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.save(logEntity);
        transaction.commit();
        session.close();
    }

    @Override
    public List<LogEntity> list() {
        Session session = getCurrentSession();
        List<LogEntity> list = session.createQuery("from LogEntity").list();
        session.close();
        return list;
    }

    @Override
    public List<LogEntity> listByTeam(Team team) {
        Session session = getCurrentSession();
        Query query = session.createQuery("from LogEntity where team_id = :team");
        query.setParameter("team", team);
        List<LogEntity> list = query.list();
        session.close();
        return list;
    }
}
