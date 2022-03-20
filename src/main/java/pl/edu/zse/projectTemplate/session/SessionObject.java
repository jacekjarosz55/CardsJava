package pl.edu.zse.projectTemplate.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.edu.zse.projectTemplate.model.User;

import java.util.Optional;

@Component
@SessionScope
public class SessionObject {

    public SessionObject() {
        this.loggedUser = Optional.empty();
    }


    private Optional<User> loggedUser;

    public void setLoggedUser(User user) {
        this.loggedUser = Optional.of(user);
    }
    public Optional<User> getLoggedUser() {
        return this.loggedUser;
    }
    public void removeLoggedUser() {
        this.loggedUser = Optional.empty();
    }
}
