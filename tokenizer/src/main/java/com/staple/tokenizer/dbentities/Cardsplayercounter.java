package com.staple.tokenizer.dbentities;

import jakarta.persistence.*;

@Entity
@Table(name = "cardsplayercounters", schema = "Cards")
public class Cardsplayercounter {
    @Id
    @Column(name = "relateid", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cardid", nullable = false)
    private Card cardid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "playercounterid", nullable = false)
    private Playercounter playercounterid;

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

    public Playercounter getPlayercounterid() {
        return playercounterid;
    }

    public void setPlayercounterid(Playercounter playercounterid) {
        this.playercounterid = playercounterid;
    }

}