package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.IUserDao;
import web.model.User;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final IUserDao userDao;

    @Autowired
    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    //@Transactional
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    //@Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    //@Transactional
    @Override
    public void editUser(User user) {
        userDao.editUser(user);
    }

    //@Transactional
    @Override
    public void deleteUser(long id) {
        User user = userDao.getUserById(id);
        if (user != null) {
            userDao.deleteUser(user);
        }
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }
}
