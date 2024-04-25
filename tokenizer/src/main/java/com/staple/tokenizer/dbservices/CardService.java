package com.staple.tokenizer.dbservices;

import com.staple.tokenizer.dbentities.Card;
import com.staple.tokenizer.dbentities.Deck;
import com.staple.tokenizer.dbentities.Token;
import com.staple.tokenizer.dbrepositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public void addDeck(String deckName, List<Integer> cardIds) {
            cardRepository.addDeckName(deckName);
        for(Integer cardid: cardIds) {
            cardRepository.addDeck(cardid);
        }
    }
    public List<Object> getCards(String cardName) {
        return cardRepository.getCards(cardName);
    }

    public  List<Deck> getDecks()
    {
        List<Object[]> decksObjects = cardRepository.getDecks();
        List<Deck> decks = new ArrayList<>();
        for (Object[] objectArray : decksObjects) {
            Deck deck = new Deck();
            deck.setId((Long) objectArray[0]);
            deck.setName((String) objectArray[1]);
            decks.add(deck);
        }
        return decks;
    }

    public List<Card> postCardsOfChosenDeck(Deck deck)
    {
        List<Object[]> cardsObjects = cardRepository.postCardsOfChosenDeck(deck.getId());
        List<Card> cards = new ArrayList<>();
        for (Object[] objectArray : cardsObjects)
        {
            Card card = new Card();
            card.setId((Long) objectArray [0]);
            card.setName((String) objectArray[1]);
            card.setPicUrl((String) objectArray[2]);
            cards.add(card);
        }
        return cards;
    }
}

