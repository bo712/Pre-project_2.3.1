package web.service;

import web.model.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    void addUser(User user);

    void editUser(User user);

    void deleteUser(long id);

    User getUserById(long id);

    User getUserByUsername(String username);
}
