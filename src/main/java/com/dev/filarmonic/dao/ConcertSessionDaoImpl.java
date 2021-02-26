package com.dev.filarmonic.dao;

import com.dev.filarmonic.exception.DataProcessException;
import com.dev.filarmonic.model.ConcertSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ConcertSessionDaoImpl implements ConcertSessionDao {
    private final SessionFactory sessionFactory;

    public ConcertSessionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ConcertSession add(ConcertSession concertSession) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(concertSession);
            transaction.commit();
            return concertSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessException("Can't add concert session " + concertSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<ConcertSession> findAvailableSessions(Long concertId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            Query<ConcertSession> query = session.createQuery("from ConcertSession ms "
                    + "join fetch ms.concert "
                    + "join fetch ms.stage "
                    + "where ms.concert.id = :concertId "
                    + "and date_format(ms.showTime, '%Y-%m-%d') = :date",
                    ConcertSession.class);
            query.setParameter("concertId", concertId);
            query.setParameter("date", date.toString());
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessException("Can't find available session for concert with id:"
                + concertId + " and date " + date, e);
        }
    }

    @Override
    public ConcertSession update(ConcertSession concertSession) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(concertSession);
            transaction.commit();
            return concertSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessException("Can't update concert session " + concertSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.createQuery("delete from ConcertSession where id = :id")
                .setParameter("id", id)
                    .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessException("Can't delete concert session with id: " + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<ConcertSession> getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Query<ConcertSession> query = session.createQuery("from ConcertSession where id=:id",
                    ConcertSession.class)
                    .setParameter("id", id);
            return query.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessException("Can`t find concert session with this id: " + id, e);
        }
    }
}
