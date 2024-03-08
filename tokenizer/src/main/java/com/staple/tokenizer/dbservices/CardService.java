package com.staple.tokenizer.dbservices;

import com.staple.tokenizer.dbentities.Card;
import com.staple.tokenizer.dbrepositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getCards() {
        return cardRepository.getCards();
    }
}

