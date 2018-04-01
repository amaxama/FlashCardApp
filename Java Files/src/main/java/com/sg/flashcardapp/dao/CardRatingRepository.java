/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.dao;

import com.sg.flashcardapp.model.CardRating;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author betzler
 */
public interface CardRatingRepository  extends JpaRepository<CardRating, Integer> {
    
}
