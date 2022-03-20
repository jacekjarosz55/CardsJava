package pl.edu.zse.projectTemplate.services;

import pl.edu.zse.projectTemplate.model.User;

import java.util.Optional;

public interface IUserService {
    void addUser(User user);
    void editUser(User user);
    void removeUser(User user);
    Optional<User> getUserByUsername(String username);
}
