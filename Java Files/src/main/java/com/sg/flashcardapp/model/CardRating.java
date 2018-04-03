/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @authors Mike Betzler, Jacob Duerr, Anna Maxam, Jeff Peterson
 */
@Entity
//@IdClass(CompositeKeyRating.class)
public class CardRating {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private int cardRatingId;
    
    @Column(nullable = false)
    private int userId;
    
    @Column(nullable = false)
    private int cardId;
    
    @NotEmpty(message = "Please enter a rating: 1 is the lowest and 5 is the highest.")
    @Length(max = 1, message = "Rating cannot exceed 5.")
    @Column(nullable = false)
    private Integer rating;

    public int getCardRatingId() {
        return cardRatingId;
    }

    public void setCardRatingId(int cardRatingId) {
        this.cardRatingId = cardRatingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.cardRatingId;
        hash = 29 * hash + this.userId;
        hash = 29 * hash + this.cardId;
        hash = 29 * hash + Objects.hashCode(this.rating);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CardRating other = (CardRating) obj;
        if (this.cardRatingId != other.cardRatingId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        if (this.cardId != other.cardId) {
            return false;
        }
        if (!Objects.equals(this.rating, other.rating)) {
            return false;
        }
        return true;
    }

    
    
}
