package pl.edu.zse.projectTemplate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.zse.projectTemplate.session.SessionObject;

@Controller
public class MainController {

    private final SessionObject sessionObject;

    @Autowired
    public MainController(SessionObject sessionObject) {
        this.sessionObject = sessionObject;
    }


    @ModelAttribute
    public void addUserAttribute(Model model) {
        model.addAttribute("user", sessionObject.getLoggedUser());
    }

    @RequestMapping(path = "/")
    public String rootPath() {
        return "redirect:/main";
    }

    @RequestMapping(path = "/main")
    public String mainPage(Model model) {
        if (sessionObject.isLoggedIn()) {
            model.addAttribute("user", sessionObject.getLoggedUser());
        }
        model.addAttribute("page", "main");
        return "main";
    }

    @RequestMapping(path = "/contact")
    public String contactPage(Model model) {
        model.addAttribute("page", "contact");
        return "contact";
    }

}
