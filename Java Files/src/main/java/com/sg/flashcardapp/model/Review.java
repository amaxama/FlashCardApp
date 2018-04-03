/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 *
 * @authors Mike Betzler, Jacob Duerr, Anna Maxam, Jeff Peterson
 */
@Entity
//@IdClass(CompositeKeyReview.class)
public class Review {
    
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column
//    private int reviewId;
//    @Id
//    private int userId;
//    @Id
//    private int deckId;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    private int reviewId;
    @Column(nullable = false)
    private int userId;
    @Column(nullable = false)
    private int deckId;
    
    @Column(nullable = false)
    private String reviewName;
    
    @Column(nullable = false)
    private String reviewContent;

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

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

    public String getReviewName() {
        return reviewName;
    }

    public void setReviewName(String reviewName) {
        this.reviewName = reviewName;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.reviewId;
        hash = 53 * hash + this.userId;
        hash = 53 * hash + this.deckId;
        hash = 53 * hash + Objects.hashCode(this.reviewName);
        hash = 53 * hash + Objects.hashCode(this.reviewContent);
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
        final Review other = (Review) obj;
        if (this.reviewId != other.reviewId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        if (this.deckId != other.deckId) {
            return false;
        }
        if (!Objects.equals(this.reviewName, other.reviewName)) {
            return false;
        }
        if (!Objects.equals(this.reviewContent, other.reviewContent)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
