package com.staple.tokenizer.dbservices;

import com.staple.tokenizer.dbentities.Card;
import com.staple.tokenizer.dbentities.Deck;
import com.staple.tokenizer.dbentities.DeckChanges;
import com.staple.tokenizer.dbrepositories.CardRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

//    public void addDeck(String deckName, List<Integer> cardIds) {
//        cardRepository.addDeck(deckName);
//        for(Integer cardid: cardIds) {
//            cardRepository.addCardToDeck(Long.valueOf(cardid));
//        }
//    }
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
        return getCards(cardsObjects);
    }

    public List<Card> getAllCards()
    {
        List<Object[]> cardsObjects = cardRepository.getAllCards();
        return getCards(cardsObjects);
    }

    private List<Card> getCards(List<Object[]> cardsObjects) {
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

    public void deleteDeck(Deck deck)
    {
        cardRepository.deleteDeck(deck.getId());
    }

    public void changeOrCreateDeck(DeckChanges deckChanges)
    {
        Integer deckId = deckChanges.getDeckId();
        String newName = deckChanges.getNewName();
        List<Card> deletedCards = deckChanges.getDeletedCards();
        List<Card> addedCards = deckChanges.getAddedCards();

        if (deckId == null)
        {
            if (newName != null)
            {
                cardRepository.addDeck(newName);
            }
            deckId = Math.toIntExact(cardRepository.getMaxDeckId());
        }
        else if (newName != null)
        {
            cardRepository.updateDeck(Long.valueOf(deckId), newName);
        }

        for(Card item : deletedCards)
        {
            cardRepository.deleteCardFromDeck(item.getId(), Long.valueOf(deckId));
        }

        for(Card item : addedCards)
        {
            cardRepository.addCardToDeck(item.getId(), Long.valueOf(deckId));
        }

    }
}

