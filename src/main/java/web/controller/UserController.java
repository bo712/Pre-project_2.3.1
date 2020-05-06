package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import web.model.User;
import web.service.IUserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getIndex() {
        return "index";
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/users")
    public String getUsers(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping("/addForm")
    public String getAddForm(ModelMap model) {
        return "add";
    }

    @RequestMapping("/add")
    public RedirectView addUser(ModelMap model,
                                @RequestParam("name") String name,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("salary") String strSalary) {

        double salary = parseSalary(strSalary);
        if (salary != -1) {
            User user = new User(name, lastName, salary);
            userService.addUser(user);
        }
        return new RedirectView("users");
    }

    @RequestMapping("/edit")
    public String editUser(ModelMap model, @RequestParam("id") Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "edit";
        }
        return "users";
    }

    @RequestMapping("/save")
    public RedirectView saveEdited(ModelMap model,
                                   @RequestParam("id") Long id,
                                   @RequestParam("name") String name,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("salary") String strSalary) {

        User user;
        double salary = parseSalary(strSalary);
        if (salary != -1 && (user = userService.getUserById(id)) != null) {
            user.setName(name);
            user.setLastName(lastName);
            user.setSalary(salary);
            userService.editUser(user);
        }
        return new RedirectView("users");
    }

    @RequestMapping("/delete")
    public RedirectView deleteUser(ModelMap model, @RequestParam("id") Long id) {
        userService.deleteUser(id);
        return new RedirectView("users");
    }

    private double parseSalary(String salary) {
        double result = -1.0;
        try {
            result = Double.parseDouble(salary);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return result;
    }
}
