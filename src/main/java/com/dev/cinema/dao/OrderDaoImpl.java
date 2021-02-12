package com.dev.cinema.dao;

import com.dev.cinema.exception.DataProcessException;
import com.dev.cinema.model.Order;
import com.dev.cinema.model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {
    private final SessionFactory sessionFactory;

    public OrderDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Order add(Order order) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
            return order;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessException("Can't add order " + order, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        try (Session session = sessionFactory.openSession()) {
            Query<Order> query = session.createQuery("select distinct o from Order o"
                    + " join fetch o.tickets where o.user = :user",
                    Order.class)
                    .setParameter("user", user);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessException("Can`t find orders by user: " + user, e);
        }
    }
}
