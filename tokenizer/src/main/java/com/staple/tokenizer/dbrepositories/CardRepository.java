package com.staple.tokenizer.dbrepositories;

import com.staple.tokenizer.dbentities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    @Query(value = "SELECT c.name AS card_name, c.pic_url AS card_pic_url,\n" +
            "       t.name AS token_name, t.pic_url AS token_pic_url,\n" +
            "       pc.name AS permcounter_name, pc.pic_url AS permcounter_pic_url,\n" +
            "       plc.name AS playercounter_name, plc.pic_url AS playercounter_pic_url,\n" +
            "       e.name AS emblem_name, e.pic_url AS emblem_pic_url,\n" +
            "       d.name AS deck_name,\n" +
            "       p.name AS player_name\n" +
            "FROM cards c\n" +
            "LEFT JOIN cardstokens ct ON c.cardid = ct.cardid\n" +
            "LEFT JOIN tokens t ON ct.tokenid = t.tokenid\n" +
            "LEFT JOIN cardspermcounters cpc ON c.cardid = cpc.cardid\n" +
            "LEFT JOIN permcounters pc ON cpc.permcounterid = pc.permcounterid\n" +
            "LEFT JOIN cardsplayercounters cplc ON c.cardid = cplc.cardid\n" +
            "LEFT JOIN playercounters plc ON cplc.playercounterid = plc.playercounterid\n" +
            "LEFT JOIN cardsemblems ce ON c.cardid = ce.cardid\n" +
            "LEFT JOIN emblems e ON ce.emblemid = e.emblemid\n" +
            "LEFT JOIN cardsdecks cd ON c.cardid = cd.cardid\n" +
            "LEFT JOIN decks d ON cd.deckid = d.deckid\n" +
            "LEFT JOIN cardsplayers cp ON c.cardid = cp.cardid\n" +
            "LEFT JOIN players p ON cp.playerid = p.playerid\n" +
            "WHERE LOWER(c.name) = LOWER(:cardName);\n", nativeQuery = true)
    List<Object> getCards(@Param("cardName") String cardName);

    @Query(value = "SELECT * FROM decks;", nativeQuery = true)
    List<Object[]> getDecks();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO decks(name) VALUES(:deckName);", nativeQuery = true)
    void addDeck(@Param("deckName") String deckName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE decks SET decks.name = :deckName WHERE (decks.deckid = :deckId);", nativeQuery = true)
    void updateDeck(@Param("deckId") Long deckId, @Param("deckName") String deckName);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO cardsdecks(cardid, deckid, cardcount) VALUES(:cardId, :deckId, 1);", nativeQuery = true)
    void addCardToDeck(@Param("cardId") Long cardId, @Param("deckId") Long deckId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM cardsdecks WHERE (cardsdecks.cardid = :cardId) AND (cardsdecks.deckid = :deckId);", nativeQuery = true)
    void deleteCardFromDeck(@Param("cardId") Long cardId, @Param("deckId") Long deckId);

    @Query(value = "SELECT MAX(deckid) FROM decks;", nativeQuery = true)
    Long getMaxDeckId();


    @Query(value = "SELECT cards.cardid, cards.name, cards.pic_url FROM cards LEFT JOIN cardsdecks ON cards.cardid = cardsdecks.cardid WHERE (cardsdecks.deckid = :deckId);", nativeQuery = true)
    List<Object[]> postCardsOfChosenDeck(@Param("deckId") Long deckId);

    @Query(value = "SELECT * FROM cards;", nativeQuery = true)
    List<Object[]> getAllCards();

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM decks WHERE (decks.deckid = :deckId);", nativeQuery = true)
    void deleteDeck(@Param("deckId") Long deckId);
}

