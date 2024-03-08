package com.staple.tokenizer.dbrepositories;

import com.staple.tokenizer.dbentities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    @Query(value = "SELECT * FROM CARDS c WHERE c.cardid = 2", nativeQuery = true)
    List<Card> getCards();
}

