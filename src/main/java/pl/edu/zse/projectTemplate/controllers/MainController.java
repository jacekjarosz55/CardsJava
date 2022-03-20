package pl.edu.zse.projectTemplate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.zse.projectTemplate.session.SessionObject;

@Controller
public class MainController {

    private final SessionObject sessionObject;

    @Autowired
    public MainController(SessionObject sessionObject) {
        this.sessionObject = sessionObject;
    }

    @RequestMapping(path = "/")
    public String rootPath() {
        return "redirect:/main";
    }

    @RequestMapping(path = "/main")
    public String mainPage(Model model) {
        model.addAttribute("user", sessionObject.getLoggedUser())
        return "main";
    }
    
}
