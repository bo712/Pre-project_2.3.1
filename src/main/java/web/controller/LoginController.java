package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Role;
import web.model.User;
import web.service.IRoleService;
import web.service.IUserService;

import java.util.HashSet;
import java.util.Set;

@Controller
public class LoginController {

    private final IRoleService roleService;

    private final IUserService userService;

    @Autowired
    public LoginController(IRoleService roleService, IUserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping(value = "login")
    public String loginPage() {
        roleService.setDefaultRoles();
        return "login";
    }

    @GetMapping(value = "register")
    public String registerPage() {
        roleService.setDefaultRoles();
        return "register";
    }

    @PostMapping(value = "register")
    public String commitRegistration(Model map,
                                     @RequestParam("name") String name,
                                     @RequestParam("lastName") String lastName,
                                     @RequestParam("username") String username,
                                     @RequestParam("password") String password) {

        User user = userService.getUserByUsername(username);
        if (user == null) {
            Set<Role> roles = new HashSet<>();
            roles.add(new Role());
            user = new User(name, lastName, username, password, roles);
            userService.addUser(user);
            map.addAttribute("user", user);
            return "user";
        }
        return "register";
    }
}
