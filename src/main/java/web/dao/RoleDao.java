package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDao implements IRoleDao {

    /* container creates the EntityManager from the EntityManagerFactory */
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void setDefaultRoles() {
        entityManager.persist(new Role("ADMIN"));
        entityManager.persist(new Role("USER"));
    }

    @Override
    public boolean isRolesEmpty() {
        List<Role> list = entityManager.createQuery("FROM Role", Role.class).getResultList();
        return (list.size() == 0);
    }
}
