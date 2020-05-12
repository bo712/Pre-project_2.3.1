package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

public interface IUserService {

    List<User> getAllUsers();

    void addUser(User user);

    void editUser(User user);

    void deleteUser(long id);

    User getUserById(long id);

    User getUserByUsername(String username);

    Set<Role> getBdRoles();

    Role getRoleByRoleName(String role);
}
