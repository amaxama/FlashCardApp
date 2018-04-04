/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.dao;

import com.sg.flashcardapp.model.Review;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author betzler
 */
public interface ReviewRepository extends JpaRepository<Review, Integer>  {
    @Query("SELECT r FROM Review r INNER JOIN User u ON u.userId = r.userId WHERE u.userId = ?1")
    List<Review> getReviewsByUserId(int id);
}
