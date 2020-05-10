package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import web.model.Role;
import web.model.User;
import web.service.IRoleService;
import web.service.IUserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    private final IUserService userService;

    private final IRoleService roleService;

    @Autowired
    public UserController(IUserService userService, IRoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC-SECURITY application");
        model.addAttribute("messages", messages);
        return "hello";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        roleService.setDefaultRoles();
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
    public RedirectView addUser(@RequestParam("name") String name,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("salary") String strSalary,
                                @RequestParam("username") String username,
                                @RequestParam("password") String password,
                                @RequestParam(required = false, name = "roleAdmin") String roleAdmin,
                                @RequestParam(required = false, name = "roleUser") String roleUser) {

        double salary = parseSalary(strSalary);
        if (salary != -1) {
            Set<Role> roles = fillRoles(roleAdmin, roleUser);
            User user = new User(name, lastName, salary, username, password, roles);
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
    public RedirectView saveEdited(@RequestParam("id") long id,
                                   @RequestParam("name") String name,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("salary") String strSalary,
                                   @RequestParam("username") String username,
                                   @RequestParam("password") String password,
                                   @RequestParam(required = false, name = "roleAdmin") String roleAdmin,
                                   @RequestParam(required = false, name = "roleUser") String roleUser) {


        User user = userService.getUserById(id);
        double salary = parseSalary(strSalary);
        Set<Role> roles = fillRoles(roleAdmin, roleUser);
        if (salary != -1 && user != null) {
            user.setName(name);
            user.setLastName(lastName);
            user.setSalary(salary);
            user.setUsername(username);
            user.setPassword(password);
            user.setRoles(roles);
            userService.editUser(user);
        }
        return new RedirectView("users");
    }

    @RequestMapping("/delete")
    public RedirectView deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return new RedirectView("users");
    }

    private Set<Role> fillRoles(String roleAdmin, String roleUser) {
        Set<Role> roles = new HashSet<>();
        if ("on".equals(roleAdmin) && "on".equals(roleUser)) {
            roles.add(new Role(1, "ADMIN"));
            roles.add(new Role());
        } else if ("on".equals(roleAdmin)) {
            roles.add(new Role(1, "ADMIN"));
        } else {
            roles.add(new Role());
        }
        return roles;
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
