package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Override
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();
        users.add(new User("Vasya", "Pupkin", 250));
        users.add(new User("BMW X3", "yellow", 280));
        users.add(new User("Tesla Model S", "black", 310));

        return users;
    }
}
