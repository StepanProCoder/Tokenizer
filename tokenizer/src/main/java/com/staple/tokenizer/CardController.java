package com.staple.tokenizer;

import com.staple.tokenizer.dbentities.Card;
import com.staple.tokenizer.dbservices.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/{card}")
    public ResponseEntity<Card> getCard() {
        Card card = cardService.getCards().get(0);
        return ResponseEntity.ok(card);
    }
}