package pl.edu.zse.projectTemplate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.zse.projectTemplate.model.Card;
import pl.edu.zse.projectTemplate.repostitories.CardRepository;

import java.util.Optional;

@Service
public class CardService implements ICardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Optional<Card> findCardById(Long id) {
        return cardRepository.findById(id);
    }

    @Override
    public void addCard(Card card) {
        cardRepository.save(card);
    }

    @Override
    public void editCard(Card card) {
        if(cardRepository.existsById(card.getId())) {
            cardRepository.save(card);
        }
    }

    @Override
    public void deleteCard(Card card) {
        cardRepository.delete(card);
    }
}