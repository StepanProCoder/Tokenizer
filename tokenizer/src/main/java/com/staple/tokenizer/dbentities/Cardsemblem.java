package com.staple.tokenizer.dbentities;

import jakarta.persistence.*;

@Entity
@Table(name = "cardsemblems", schema = "Cards")
public class Cardsemblem {
    @Id
    @Column(name = "relateid", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cardid", nullable = false)
    private Card cardid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emblemid", nullable = false)
    private Emblem emblemid;

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

    public Emblem getEmblemid() {
        return emblemid;
    }

    public void setEmblemid(Emblem emblemid) {
        this.emblemid = emblemid;
    }

}