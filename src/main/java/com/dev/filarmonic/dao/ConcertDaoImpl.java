package com.dev.filarmonic.dao;

import com.dev.filarmonic.exception.DataProcessException;
import com.dev.filarmonic.model.Concert;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ConcertDaoImpl implements ConcertDao {
    private final SessionFactory sessionFactory;

    public ConcertDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Concert add(Concert concert) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(concert);
            transaction.commit();
            return concert;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessException("Can`t insert Concert entity " + concert, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Concert> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Concert> getAllConcertsQuery = session.createQuery("from Concert", Concert.class);
            return getAllConcertsQuery.list();
        } catch (Exception e) {
            throw new DataProcessException("Can`t get all concerts: ", e);
        }
    }

    @Override
    public Optional<Concert> getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Query<Concert> getByIdQuery = session.createQuery("from Concert where id =:id",
                    Concert.class).setParameter("id", id);
            return Optional.ofNullable(getByIdQuery.getSingleResult());
        } catch (Exception e) {
            throw new DataProcessException("Can`t get concert by id: " + id, e);
        }
    }
}
