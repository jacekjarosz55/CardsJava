package pl.edu.zse.projectTemplate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.zse.projectTemplate.model.Card;
import pl.edu.zse.projectTemplate.model.User;
import pl.edu.zse.projectTemplate.repostitories.UserRepository;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void editUser(User user) {
        if (userRepository.existsById(user.getId())) {
            userRepository.save(user);
        }
    }

    @Override
    public void addCardToUser(User user, Card card) {
        Set<Card> cards = user.getCards();
        if(cards.add(card)) {
            user.setCards(cards);
            userRepository.save(user);
        }
    }

    @Override
    public void removeUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}