package pl.edu.zse.projectTemplate.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.zse.projectTemplate.session.SessionObject;

@Controller
public class CardsController {

    private final SessionObject sessionObject;

    @Autowired
    public CardsController(SessionObject sessionObject) {
        this.sessionObject = sessionObject;
    }

    @ModelAttribute
    public void addUserAttribute(Model model) {
        model.addAttribute("user", sessionObject.getLoggedUser());
    }

   @RequestMapping("/cards")
    public String cardsPage(Model model) {
       model.addAttribute("page", "cards");
       return "cards";
   }
}
