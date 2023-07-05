package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

@Repository
public class UserDAO implements DAO {

    private final SessionFactory sessionFactory;
    @Autowired
    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    @Transactional
    public User getUserById(long id) {

        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    @Transactional
    public void update(long id, User newUser) {
        User subsistentUser = getUserById(id);
        subsistentUser.setName(newUser.getName());
        subsistentUser.setAge(newUser.getAge());
    }

    @Override
    public void delete(long id) {

        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        session.remove(user);
    }
}
