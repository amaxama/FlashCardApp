/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.dao;

import com.sg.flashcardapp.model.Card;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @authors Mike Betzler, Jacob Duerr, Anna Maxam, Jeff Peterson
 */
public interface CardRepository extends JpaRepository<Card, Integer> {
//@Query("SELECT c FROM Card c INNER JOIN CardRating cr ON c.CardId = cr.CardId WHERE cr.Rating = ?1")
//List<Card> findCardByRating(int Rating);
}
