package com.staple.tokenizer.dbentities;

import jakarta.persistence.*;

@Entity
@Table(name = "cardstokens", schema = "Cards")
public class Cardstoken {
    @Id
    @Column(name = "relateid", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cardid", nullable = false)
    private Card cardid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tokenid", nullable = false)
    private Token tokenid;

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

    public Token getTokenid() {
        return tokenid;
    }

    public void setTokenid(Token tokenid) {
        this.tokenid = tokenid;
    }

}