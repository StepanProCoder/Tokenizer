package com.staple.tokenizer.dbentities;

import jakarta.persistence.*;

@Entity
@Table(name = "decksplayers", schema = "Cards")
public class Decksplayer {
    @Id
    @Column(name = "relateid", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "deckid", nullable = false)
    private Deck deckid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "playerid", nullable = false)
    private Player playerid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Deck getDeckid() {
        return deckid;
    }

    public void setDeckid(Deck deckid) {
        this.deckid = deckid;
    }

    public Player getPlayerid() {
        return playerid;
    }

    public void setPlayerid(Player playerid) {
        this.playerid = playerid;
    }

}