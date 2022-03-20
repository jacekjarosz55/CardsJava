package pl.edu.zse.projectTemplate.services;

import pl.edu.zse.projectTemplate.model.User;

public interface IAuthenticationService {
    void registerUser(String username, String password, String repeatpassword, String email);
    void logoutUser();
    void loginUser(String username, String password);
}
