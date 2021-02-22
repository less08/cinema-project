package com.dev.cinema.dao;

import com.dev.cinema.exception.DataProcessException;
import com.dev.cinema.model.Role;
import com.dev.cinema.model.RoleType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    private final SessionFactory sessionFactory;

    @Autowired
    private RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Role role) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessException("Can't add role " + role, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Role getRoleByName(String roleName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Role> query = session.createQuery("from Role where roleType=:roleName",
                    Role.class).setParameter("roleName", RoleType.valueOf(roleName));
            return query.getSingleResult();
        } catch (Exception e) {
            throw new DataProcessException("Can`t find role named: " + roleName, e);
        }
    }
}
