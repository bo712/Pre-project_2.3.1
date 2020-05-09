package web.dao;

import web.model.Role;
import web.model.User;

import java.util.Set;

public interface IRoleDao {

    Set<Role> getRoles();

    void setRoles(User user, long[] rolesId);

    void setRole(User user, long roleId);

    void setDefaultRoles();

    Role getRoleById(long id);
}
