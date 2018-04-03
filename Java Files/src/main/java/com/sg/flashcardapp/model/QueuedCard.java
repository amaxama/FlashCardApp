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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @authors Mike Betzler, Jacob Duerr, Anna Maxam, Jeff Peterson
 */
@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class QueuedCard {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private int queuedCardId;

    @Column(nullable = false)
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

    @ManyToMany
    @JoinTable(name = "QueuedCardCategory",
            joinColumns = {
                @JoinColumn(name = "queuedCardId")},
            inverseJoinColumns = {
                @JoinColumn(name = "categoryId")}
    )
    private List<Category> categories = new ArrayList<>();

    public int getQueuedCardId() {
        return queuedCardId;
    }

    public void setQueuedCardId(int queuedCardId) {
        this.queuedCardId = queuedCardId;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.queuedCardId;
        hash = 37 * hash + this.cardId;
        hash = 37 * hash + Objects.hashCode(this.cardName);
        hash = 37 * hash + Objects.hashCode(this.cardChallenge);
        hash = 37 * hash + Objects.hashCode(this.cardAnswer);
        hash = 37 * hash + Objects.hashCode(this.categories);
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
        final QueuedCard other = (QueuedCard) obj;
        if (this.queuedCardId != other.queuedCardId) {
            return false;
        }
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
        if (!Objects.equals(this.categories, other.categories)) {
            return false;
        }
        return true;
    }



    
}
