package pl.edu.zse.projectTemplate.services;

import pl.edu.zse.projectTemplate.model.Card;

import java.util.Optional;

public interface ICardService {
    public Optional<Card> findCardById(Long id);
    public void addCard(Card card);
    public void editCard(Card card);
    public void deleteCard(Card card);
}
