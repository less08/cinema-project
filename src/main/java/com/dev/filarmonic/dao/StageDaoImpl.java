package com.dev.filarmonic.dao;

import com.dev.filarmonic.exception.DataProcessException;
import com.dev.filarmonic.model.Stage;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class StageDaoImpl implements StageDao {
    private final SessionFactory sessionFactory;

    public StageDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Stage add(Stage stage) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(stage);
            transaction.commit();
            return stage;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessException("Can`t add stage " + stage, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Stage> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Stage> query = session.createQuery("from Stage", Stage.class);
            return query.list();
        } catch (Exception e) {
            throw new DataProcessException("Can't get all stages", e);
        }
    }

    @Override
    public Optional<Stage> getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Query<Stage> query = session
                    .createQuery("from Stage where id=:id", Stage.class)
                    .setParameter("id", id);
            return Optional.ofNullable(query.getSingleResult());
        } catch (Exception e) {
            throw new DataProcessException("Can't get stage by id: " + id, e);
        }
    }
}
