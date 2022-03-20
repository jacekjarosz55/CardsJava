package pl.edu.zse.projectTemplate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.zse.projectTemplate.model.User;
import pl.edu.zse.projectTemplate.session.SessionObject;

import javax.annotation.Resource;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class AuthenticationService implements IAuthenticationService {

    private final UserService userService;

    @Resource
    private final SessionObject userSessionObject;

    @Autowired
    public AuthenticationService(UserService userService, SessionObject userSessionObject) {
        this.userService = userService;
        this.userSessionObject = userSessionObject;
    }

    private String hashPassword(String password) {
        String result = "";
        try {
            MessageDigest md;
            md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] md5bytes = md.digest();
            result = DatatypeConverter.printHexBinary(md5bytes);
        } catch (NoSuchAlgorithmException e) {
            // this is pretty much unreachable?
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void registerUser(String username, String password, String repeatpassword, String email) {
        if(!userService.getUserByUsername(username).isPresent()) {
            User user = new User(username, hashPassword(password), email, 0);
            System.out.println(user.getHashedpassword());
            userService.addUser(user);
            System.out.println("Registered: " + user.getUsername());
        }
        else System.out.println("already exists");
    }

    @Override
    public void logoutUser() {
        userSessionObject.removeLoggedUser();
        System.out.println("Logged out");
    }

    @Override
    public void loginUser(String username, String password) {
        Optional<User> userBox = userService.getUserByUsername(username);
        User user;
        if (userBox.isPresent()) {
            user = userBox.get();
            if (user.getHashedpassword().equals(hashPassword(password))) {
                userSessionObject.setLoggedUser(user);
            }
        }
    }
}
