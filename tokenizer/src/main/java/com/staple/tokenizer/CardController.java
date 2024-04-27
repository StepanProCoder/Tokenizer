package com.staple.tokenizer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.staple.tokenizer.dbentities.Card;
import com.staple.tokenizer.dbentities.Deck;
import com.staple.tokenizer.dbentities.DeckChanges;
import com.staple.tokenizer.dbentities.Token;
import com.staple.tokenizer.dbservices.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/decks/")
    public ResponseEntity<List<Deck>> getDecks()
    {
        List<Deck> decks = cardService.getDecks();
        return ResponseEntity.ok(decks);
    }

    @PostMapping("/decks/")
    public ResponseEntity<List<Card>> postCardsOfChosenDeck(@RequestBody String data)
    {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Deck deck = gson.fromJson(data, Deck.class);
        List<Card> cards = cardService.postCardsOfChosenDeck(deck);
        return ResponseEntity.ok(cards);
    }

    @GetMapping("/allcards/")
    public ResponseEntity<List<Card>> getAllCards()
    {
        List<Card> cards = cardService.getAllCards();
        return ResponseEntity.ok(cards);
    }

    @PostMapping("/deletedeck/")
    public ResponseEntity<Boolean> deleteDeck(@RequestBody Deck deck)
    {
        cardService.deleteDeck(deck);
        return ResponseEntity.ok(true);
    }

    @PostMapping("/deckchange/")
    public ResponseEntity<Boolean> changeOrCreateDeck(@RequestBody DeckChanges deckChanges)
    {
        cardService.changeOrCreateDeck(deckChanges);
        return ResponseEntity.ok(true);
    }

}