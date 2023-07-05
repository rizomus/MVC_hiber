package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.DAO;
import web.model.User;

import java.util.List;

@Service
public class UserService implements UserServiceInterface{

    @Autowired
    private DAO dao;

    @Override
    @Transactional
    public void add(User user) {
        dao.add(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return dao.getUserById(id);
    }

    @Override
    public void update(long id, User user) {
        dao.update(id, user);
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }
}
