package com.staple.tokenizer.dbentities;

import jakarta.persistence.*;

@Entity
@Table(name = "cardsdecks", schema = "Cards")
public class Cardsdeck {
    @Id
    @Column(name = "relateid", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cardid", nullable = false)
    private Card cardid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "deckid", nullable = false)
    private Deck deckid;

    @Column(name = "cardcount", nullable = false)
    private Long cardcount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Card getCardid() {
        return cardid;
    }

    public void setCardid(Card cardid) {
        this.cardid = cardid;
    }

    public Deck getDeckid() {
        return deckid;
    }

    public void setDeckid(Deck deckid) {
        this.deckid = deckid;
    }

    public Long getCardcount() {
        return cardcount;
    }

    public void setCardcount(Long cardcount) {
        this.cardcount = cardcount;
    }

}