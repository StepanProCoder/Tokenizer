package com.staple.tokenizer.dbentities;

import jakarta.persistence.*;

@Entity
@Table(name = "cardsplayers", schema = "Cards")
public class Cardsplayer {
    @Id
    @Column(name = "relateid", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cardid", nullable = false)
    private Card cardid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "playerid", nullable = false)
    private Player playerid;

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

    public Player getPlayerid() {
        return playerid;
    }

    public void setPlayerid(Player playerid) {
        this.playerid = playerid;
    }

}