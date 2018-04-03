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
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
/**
 *
 * @authors Mike Betzler, Jacob Duerr, Anna Maxam, Jeff Peterson
 */
@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Deck {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private int deckId;
    
    @NotEmpty(message = "Please enter a name.")
    @Length(max = 30, message = "Name must be no more than 30 characters in length.")
    @Column(nullable = false)
    private String deckName;
    
    @NotEmpty(message = "Please enter a name.")
    @Length(max = 100, message = "Name must be no more than 100 characters in length.")
    @Column(nullable = true)
    private String deckDesc;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "DeckCard",
            joinColumns = {@JoinColumn(name = "deckId")}, 
            inverseJoinColumns = { @JoinColumn(name = "cardId")}
    )
    private List<Card> cards = new ArrayList<>();
    
//    (fetch = FetchType.EAGER)
//    @OneToMany
//    private List<Review> reviews = new ArrayList<>();

    public Deck() {

    }

    public int getDeckId() {
        return deckId;
    }

    public void setDeckId(int deckId) {
        this.deckId = deckId;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public String getDeckDesc() {
        return deckDesc;
    }

    public void setDeckDesc(String deckDesc) {
        this.deckDesc = deckDesc;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

//    public List<Review> getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(List<Review> reviews) {
//        this.reviews = reviews;
//    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.deckId;
        hash = 97 * hash + Objects.hashCode(this.deckName);
        hash = 97 * hash + Objects.hashCode(this.deckDesc);
        hash = 97 * hash + Objects.hashCode(this.cards);
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
        final Deck other = (Deck) obj;
        if (this.deckId != other.deckId) {
            return false;
        }
        if (!Objects.equals(this.deckName, other.deckName)) {
            return false;
        }
        if (!Objects.equals(this.deckDesc, other.deckDesc)) {
            return false;
        }
        if (!Objects.equals(this.cards, other.cards)) {
            return false;
        }
        return true;
    }

    
    

}
