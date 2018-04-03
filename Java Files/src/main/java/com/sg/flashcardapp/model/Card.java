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
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


/**
 *
 * @authors Mike Betzler, Jacob Duerr, Anna Maxam, Jeff Peterson
 */
@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Card {
  
  
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column
  private int cardId;
  
  @NotEmpty(message = "Please enter a name.")
  @Length(max = 30, message = "Name must be no more than 30 characters in length.")
  @Column(nullable = false)
  private String cardName;
  
  @NotEmpty(message = "Please enter a Challenge.")
  @Length(max = 300, message = "Name must be no more than 300 characters in length.")
  @Column(nullable = false)
  private String cardChallenge;
  
  @NotEmpty(message = "Please enter an Answer.")
  @Length(max = 1000, message = "Answer must be no more than 1000 characters in length.")
  @Column(nullable = false)
  private String cardAnswer;
          
//  private List<CardRating> ratings = new ArrayList<>();
  

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.cardId;
        hash = 23 * hash + Objects.hashCode(this.cardName);
        hash = 23 * hash + Objects.hashCode(this.cardChallenge);
        hash = 23 * hash + Objects.hashCode(this.cardAnswer);
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
        return true;
    }


    
    
  
  
  
  
    
  
}
