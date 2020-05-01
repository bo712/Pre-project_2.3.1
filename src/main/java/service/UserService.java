package service;

import model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
