package com.staple.tokenizer.dbservices;

import com.staple.tokenizer.dbentities.*;
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

    public List<String> postPlacingCard(Card card)
    {
        List<Object[]> resultList = cardRepository.getCardAllPermanents(card.getId());
        List<String> stringList = new ArrayList<>();

        for (Object[] row : resultList) {
            for (Object obj : row) {
                stringList.add(obj != null ? obj.toString() : null);
            }
        }

        return stringList;
    }

    public List<Token> getAllTokens() {
        List<Object[]> tokenObjects = cardRepository.getAllTokens();
        List<Token> tokens = new ArrayList<>();
        for (Object[] objectArray : tokenObjects)
        {
            Token token = new Token();
            token.setId((Long) objectArray [0]);
            token.setName((String) objectArray[1]);
            token.setPicUrl((String) objectArray[2]);
            tokens.add(token);
        }
        return tokens;
    }

    public List<Emblem> getAllEmblems() {
        List<Object[]> emblemObjects = cardRepository.getAllEmblems();
        List<Emblem> emblems = new ArrayList<>();
        for (Object[] objectArray : emblemObjects)
        {
            Emblem emblem = new Emblem();
            emblem.setId((Long) objectArray [0]);
            emblem.setName((String) objectArray[1]);
            emblem.setPicUrl((String) objectArray[2]);
            emblems.add(emblem);
        }
        return emblems;
    }

    public List<Permcounter> getAllPermcounters() {
        List<Object[]> permcounterObjects = cardRepository.getAllPermcounters();
        List<Permcounter> permcounters = new ArrayList<>();
        for (Object[] objectArray : permcounterObjects)
        {
            Permcounter permcounter = new Permcounter();
            permcounter.setId((Long) objectArray [0]);
            permcounter.setName((String) objectArray[1]);
            permcounter.setPicUrl((String) objectArray[2]);
            permcounters.add(permcounter);
        }
        return permcounters;
    }

    public List<Playercounter> getAllPlayercounters() {
        List<Object[]> playercounterObjects = cardRepository.getAllPlayercounters();
        List<Playercounter> playercounters = new ArrayList<>();
        for (Object[] objectArray : playercounterObjects)
        {
            Playercounter playercounter = new Playercounter();
            playercounter.setId((Long) objectArray [0]);
            playercounter.setName((String) objectArray[1]);
            playercounter.setPicUrl((String) objectArray[2]);
            playercounters.add(playercounter);
        }
        return playercounters;
    }

    public void deleteCard(Card card) {
        cardRepository.deleteCard(card.getId());
    }

    public void deleteToken(Token token) {
        cardRepository.deleteToken(token.getId());
    }

    public void deleteEmblem(Emblem emblem) {
        cardRepository.deleteEmblem(emblem.getId());
    }

    public void deletePermcounter(Permcounter permcounter) {
        cardRepository.deletePermcounter(permcounter.getId());
    }

    public void deletePlayercounter(Playercounter playercounter) {
        cardRepository.deletePlayercounter(playercounter.getId());
    }
}

