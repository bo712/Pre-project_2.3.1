package web.dao;

import web.model.User;

import java.util.List;

public interface IUserDao {

    List<User> getAllUsers();

    void addUser(User user);

    void editUser(User user);

    void deleteUser(long id);

    User getUserById(long id);
}
