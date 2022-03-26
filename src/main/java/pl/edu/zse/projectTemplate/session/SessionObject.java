package pl.edu.zse.projectTemplate.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.edu.zse.projectTemplate.model.User;
import java.util.Optional;

@Component
@SessionScope
public class SessionObject {

    public SessionObject() {}

    private User loggedUser = null;

    public void setLoggedUser(User user) {
        this.loggedUser = user;
    }
    public boolean isLoggedIn() {
        return this.loggedUser != null;
    }

    public User getLoggedUser() {
        return this.loggedUser;
    }
    public void removeLoggedUser() { this.loggedUser = null; }
}
