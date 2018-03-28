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

public class CompositeKeyRating implements Serializable {
    
    private int userId;
    private int cardId;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.userId;
        hash = 67 * hash + this.cardId;
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
        final CompositeKeyRating other = (CompositeKeyRating) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.cardId != other.cardId) {
            return false;
        }
        return true;
    }
    
    
    
    
}

