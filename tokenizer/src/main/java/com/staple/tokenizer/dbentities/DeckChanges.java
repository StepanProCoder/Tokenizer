package com.staple.tokenizer.dbentities;

import java.util.ArrayList;
import java.util.List;

public class DeckChanges {
    private Integer deckId;
    private List<Card> deletedCards = new ArrayList<>();
    private List<Card> addedCards = new ArrayList<>();
    private String newName;

    public Integer getDeckId() {
        return deckId;
    }

    public List<Card> getDeletedCards() {
        return deletedCards;
    }

    public List<Card> getAddedCards() {
        return addedCards;
    }

    public String getNewName() {
        return newName;
    }

    public void setDeckId(Integer deckId) {
        this.deckId = deckId;
    }

    public void setDeletedCards(List<Card> deletedCards) {
        this.deletedCards = deletedCards;
    }

    public void setAddedCards(List<Card> addedCards) {
        this.addedCards = addedCards;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
}


