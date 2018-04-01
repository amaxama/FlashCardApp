/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 *
 * @authors Mike Betzler, Jacob Duerr, Anna Maxam, Jeff Peterson
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Card {
  
  
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column
  private int cardId;
  
  @Column(nullable = false)
  private String cardName;
  
  @Column(nullable = false)
  private String cardChallenge;
  
  @Column(nullable = false)
  private String cardAnswer;
  
  @OneToMany
  @JsonIgnore
  private List<CardRating> ratings = new ArrayList<>();
  

  public Card() {
    
  }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardChallenge() {
        return cardChallenge;
    }

    public void setCardChallenge(String cardChallenge) {
        this.cardChallenge = cardChallenge;
    }

    public String getCardAnswer() {
        return cardAnswer;
    }

    public void setCardAnswer(String cardAnswer) {
        this.cardAnswer = cardAnswer;
    }

    public List<CardRating> getRatings() {
        return ratings;
    }

    public void setRatings(List<CardRating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.cardId;
        hash = 79 * hash + Objects.hashCode(this.cardName);
        hash = 79 * hash + Objects.hashCode(this.cardChallenge);
        hash = 79 * hash + Objects.hashCode(this.cardAnswer);
        hash = 79 * hash + Objects.hashCode(this.ratings);
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
        final Card other = (Card) obj;
        if (this.cardId != other.cardId) {
            return false;
        }
        if (!Objects.equals(this.cardName, other.cardName)) {
            return false;
        }
        if (!Objects.equals(this.cardChallenge, other.cardChallenge)) {
            return false;
        }
        if (!Objects.equals(this.cardAnswer, other.cardAnswer)) {
            return false;
        }
        if (!Objects.equals(this.ratings, other.ratings)) {
            return false;
        }
        return true;
    }
    
    

    
  
  
  
  
    
  
}
