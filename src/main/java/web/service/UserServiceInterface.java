package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserServiceInterface {

    @Transactional
    public void add(User user);

    @Transactional
    public List<User> getAllUsers();

    @Transactional
    public User getUserById(long id);

    @Transactional
    public void update(long id, User user);

    @Transactional
    public void delete(long id);
}
