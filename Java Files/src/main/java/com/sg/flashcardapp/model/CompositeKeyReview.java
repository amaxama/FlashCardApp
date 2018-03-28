/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.model;

import java.io.Serializable;

/**
 *
 * @author annamaxam
 */
public class CompositeKeyReview implements Serializable {
    
    private int userId;
    private int deckId;
    private int reviewId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDeckId() {
        return deckId;
    }

    public void setDeckId(int deckId) {
        this.deckId = deckId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.userId;
        hash = 37 * hash + this.deckId;
        hash = 37 * hash + this.reviewId;
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
        final CompositeKeyReview other = (CompositeKeyReview) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.deckId != other.deckId) {
            return false;
        }
        if (this.reviewId != other.reviewId) {
            return false;
        }
        return true;
    }
    
    
    
    
}
