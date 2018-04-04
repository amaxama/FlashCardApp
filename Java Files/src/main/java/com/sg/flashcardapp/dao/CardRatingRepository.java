/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.dao;

import com.sg.flashcardapp.model.CardRating;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author betzler
 */
public interface CardRatingRepository  extends JpaRepository<CardRating, Integer> {
    @Query("SELECT cr FROM CardRating cr INNER JOIN User u ON cr.userId = u.userId WHERE u.userId = ?1")
    List<CardRating> getCardRatingsByUserId(int id);
}
