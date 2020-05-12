package web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;

@Controller
public class UserController {

    @GetMapping("/user")
    public String user(Model map) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        map.addAttribute("user", user);
        return "user";
    }
}
