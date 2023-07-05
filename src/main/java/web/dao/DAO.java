package web.dao;

import web.model.User;

import java.util.List;

public interface DAO {
    void add (User user);
    List<User> getAllUsers();
    public User getUserById(long id);
    public void update(long id, User user);
    public void delete(long id);
}
