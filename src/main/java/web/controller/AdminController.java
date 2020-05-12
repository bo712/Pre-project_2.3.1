package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Role;
import web.model.User;
import web.service.IRoleService;
import web.service.IUserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AdminController {

    private final IUserService userService;

    private final IRoleService roleService;

    @Autowired
    public AdminController(IUserService userService, IRoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String user(Model map) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        map.addAttribute("user", user);
        return "admin";
    }

    @GetMapping("/admin/users")
    public String getUsers(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/admin/add")
    public String getAddForm(ModelMap model) {
        Set<Role> roles = userService.getBdRoles();
        model.addAttribute("roles", roles);
        return "add";
    }

    @PostMapping("/admin/add")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("salary") String strSalary,
                          @RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam(required = false, name = "role") String[] rolesArr) {


        double salary = parseSalary(strSalary);
        if (salary != -1) {
            Set<Role> roles = fillRoles(rolesArr);
            User user = new User(name, lastName, salary, username, password, roles);
            userService.addUser(user);
        }
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/edit")
    public String editUser(ModelMap model, @RequestParam("id") Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            Set<Role> roles = userService.getBdRoles();
            model.addAttribute("user", user);
            model.addAttribute("roles", roles);
            return "edit";
        }
        return "redirect:/admin/users";
    }

    @PostMapping("/admin/edit")
    public String saveEdited(@RequestParam("id") long id,
                             @RequestParam("name") String name,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("salary") String strSalary,
                             @RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam(required = false, name = "role") String[] rolesArr) {

        User user = userService.getUserById(id);
        double salary = parseSalary(strSalary);
        Set<Role> roles = fillRoles(rolesArr);
        if (salary != -1 && user != null) {
            user.setName(name);
            user.setLastName(lastName);
            user.setSalary(salary);
            user.setUsername(username);
            user.setPassword(password);
            user.setRoles(roles);
            userService.editUser(user);
        }
        return "redirect:users";
    }

    @RequestMapping("/admin/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:users";
    }

    private Set<Role> fillRoles(String[] rolesArr) {
        Set<Role> roles = new HashSet<>();
        for (String role : rolesArr) {
            roles.add(userService.getRoleByRoleName(role));
        }
        if (roles.size() == 0) {
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
