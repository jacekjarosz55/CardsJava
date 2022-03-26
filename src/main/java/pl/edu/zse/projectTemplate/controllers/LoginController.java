package pl.edu.zse.projectTemplate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchUpdateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.zse.projectTemplate.services.IAuthenticationService;
import pl.edu.zse.projectTemplate.services.IUserService;
import pl.edu.zse.projectTemplate.session.SessionObject;

@Controller
public class LoginController {
    public final IAuthenticationService authService;
    public final SessionObject sessionObject;

// TODO: Make this a ControllerAdvice
    @ModelAttribute
    public void addUserAttribute(Model model) {
        model.addAttribute("user", sessionObject.getLoggedUser());
    }


    @Autowired
    public LoginController(IAuthenticationService authService, SessionObject sessionObject) {
        this.authService = authService;
        this.sessionObject = sessionObject;
    }

    @RequestMapping(path = "/register")
    public String registerPage(Model model) {
        model.addAttribute("page", "register");
        return "register";
    }

    @PostMapping(path = "/register")
    public String registerPost(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String repeatpassword ,
            @RequestParam String email)
    {
        authService.registerUser(username, password, repeatpassword, email);
        return "redirect:/main";
    }

    @RequestMapping(path = "/login")
    public String loginPage(Model model) {
        model.addAttribute("page", "login");
        return "login";
    }

    @PostMapping(path = "/login")
    public String loginPost(Model model, @RequestParam String username, @RequestParam String password) {
        authService.loginUser(username, password);
        if(sessionObject.isLoggedIn()) {
            return "redirect:/main";
        }
        else{
            model.addAttribute("error", "Incorrect login!");
            model.addAttribute("page", "login");
            return "login";
        }
    }

    @RequestMapping(path = "/logout")
    public String logout() {
        authService.logoutUser();
        return "redirect:/main";
    }

}
