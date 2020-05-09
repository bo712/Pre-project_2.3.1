package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDao implements IRoleDao {

    /* container creates the EntityManager from the EntityManagerFactory */
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Set<Role> getRoles() {
        List<Role> list = entityManager.createQuery("from Role", Role.class).getResultList();
        return new HashSet<>(list);
    }

    @Override
    public void setRoles(User user, long[] rolesId) {

    }

    @Override
    public void setRole(User user, long roleId) {

    }

    @Override
    public void setDefaultRoles() {
        entityManager.persist(new Role(1, "admin"));
        entityManager.persist(new Role(2, "user"));
    }

    @Override
    public Role getRoleById(long id) {
        return entityManager.find(Role.class, id);
    }
}
