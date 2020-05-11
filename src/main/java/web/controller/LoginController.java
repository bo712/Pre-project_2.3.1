package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.IRoleService;

@Controller
public class LoginController {

    private final IRoleService roleService;

    @Autowired
    public LoginController(IRoleService roleService) {
        this.roleService = roleService;
    }

//    @RequestMapping(value = "hello", method = RequestMethod.GET)
//    public String printWelcome(ModelMap model) {
//        List<String> messages = new ArrayList<>();
//        messages.add("Hello!");
//        messages.add("I'm Spring MVC-SECURITY application");
//        model.addAttribute("messages", messages);
//        return "hello";
//    }

    @GetMapping(value = "login")
    public String loginPage() {
        roleService.setDefaultRoles();
        return "login";
    }
}
