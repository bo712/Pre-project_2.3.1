package controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class UsersController {

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String getUsers(ModelMap model) {
        List<User> users = new UserService().getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
}
