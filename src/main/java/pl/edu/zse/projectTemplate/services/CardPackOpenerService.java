package pl.edu.zse.projectTemplate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.zse.projectTemplate.model.Card;
import pl.edu.zse.projectTemplate.model.User;
import pl.edu.zse.projectTemplate.session.SessionObject;

@Service
public class CardPackOpenerService {

    private final SessionObject sessionObject;
    private final ICardService cardService;
    private final IUserService userService;

    @Autowired
    public CardPackOpenerService(SessionObject sessionObject, ICardService cardService, IUserService userService) {
        this.sessionObject = sessionObject;
        this.cardService = cardService;
        this.userService = userService;
    }

    public void openRandomCard() {
        if(sessionObject.isLoggedIn()) {
            Card droppedCard = cardService.findCardById(0L).orElseThrow();
            User user = sessionObject.getLoggedUser();
            userService.addCardToUser(user, droppedCard);
        }
    }

}
