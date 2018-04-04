/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.dao;

import com.sg.flashcardapp.model.Deck;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author JP
 */
public interface DeckRepository extends JpaRepository<Deck, Integer> {
//    @Query("SELECT d FROM Deck d INNER JOIN UserDeck ud ON d.deckId = ud.deckId INNER JOIN User u ON ud.userId = u.userId WHERE u.userId = ?1")
//    List<Deck> getDecksByUserId(int id);
    
}
