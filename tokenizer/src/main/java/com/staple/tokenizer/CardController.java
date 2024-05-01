package com.staple.tokenizer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.staple.tokenizer.dbentities.*;
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

    @PostMapping("/allperm/")
    public ResponseEntity<List<String>> postPlacingCard(@RequestBody Card card)
    {
        List<String> result = cardService.postPlacingCard(card);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/permeditcards/")
    public ResponseEntity<List<Card>> permGetCards()
    {
        List<Card> cards = cardService.getAllCards();
        return ResponseEntity.ok(cards);
    }

    @GetMapping("permedittokens/")
    public ResponseEntity<List<Token>> permGetTokens()
    {
        List<Token> tokens = cardService.getAllTokens();
        return ResponseEntity.ok(tokens);
    }

    @GetMapping("permeditemblems/")
    public ResponseEntity<List<Emblem>> permGetEmblems()
    {
        List<Emblem> emblems = cardService.getAllEmblems();
        return ResponseEntity.ok(emblems);
    }

    @GetMapping("permeditpermcounters/")
    public ResponseEntity<List<Permcounter>> permGetPermcounters()
    {
        List<Permcounter> permcounters = cardService.getAllPermcounters();
        return ResponseEntity.ok(permcounters);
    }

    @GetMapping("permeditplayercounters/")
    public ResponseEntity<List<Playercounter>> permGetPlayercounters()
    {
        List<Playercounter> playercounters = cardService.getAllPlayercounters();
        return ResponseEntity.ok(playercounters);
    }

    @PostMapping("permeditcards/")
    public ResponseEntity<Boolean> deleteCard(@RequestBody Card card)
    {
        cardService.deleteCard(card);
        return ResponseEntity.ok(true);
    }

    @PostMapping("permedittokens/")
    public ResponseEntity<Boolean> deleteToken(@RequestBody Token token)
    {
        cardService.deleteToken(token);
        return ResponseEntity.ok(true);
    }

    @PostMapping("permeditemblem/")
    public ResponseEntity<Boolean> deleteEmblem(@RequestBody Emblem emblem)
    {
        cardService.deleteEmblem(emblem);
        return ResponseEntity.ok(true);
    }

    @PostMapping("permeditpermcounters/")
    public ResponseEntity<Boolean> deletePermcounter(@RequestBody Permcounter permcounter)
    {
        cardService.deletePermcounter(permcounter);
        return ResponseEntity.ok(true);
    }

    @PostMapping("permeditplayercounters/")
    public ResponseEntity<Boolean> deletePlayercounter(@RequestBody Playercounter playercounter)
    {
        cardService.deletePlayercounter(playercounter);
        return ResponseEntity.ok(true);
    }

}