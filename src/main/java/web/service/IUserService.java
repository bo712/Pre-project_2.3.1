package web.service;

import web.model.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    void addUser(User user);

    void editUser(long id);

    void deleteUser(long id);
}
