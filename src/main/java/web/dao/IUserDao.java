package web.dao;

import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

public interface IUserDao {

    List<User> getAllUsers();

    void addUser(User user);

    void editUser(User user);

    void deleteUser(User user);

    User getUserById(long id);

    User getUserByUsername(String username);

    Set<Role> getBdRoles();

    Role getRoleByRoleName(String role);
}
