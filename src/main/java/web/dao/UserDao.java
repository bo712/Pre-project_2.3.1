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
public class UserDao implements IUserDao {

    /* container creates the EntityManager from the EntityManagerFactory */
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByUsername(String username) {
        List<User> list = entityManager
                .createQuery("FROM User where username=:username", User.class)
                .setParameter("username", username)
                .getResultList();
        return list.size() == 0 ? null : list.get(0);
    }

    @Override
    public Set<Role> getBdRoles() {
        List<Role> roles = entityManager.createQuery("FROM Role", Role.class).getResultList();
        return new HashSet<>(roles);
    }
}
