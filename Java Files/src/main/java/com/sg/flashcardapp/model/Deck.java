/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
/**
 *
 * @authors Mike Betzler, Jacob Duerr, Anna Maxam, Jeff Peterson
 */
@Entity
public class Deck {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private int deckId;
    
    @Column(nullable = false)
    private String deckName;
    
    @Column
    private String deckDesc;
    
    @ManyToMany
    @JoinTable(name = "DeckCard",
            joinColumns = {@JoinColumn(name = "deckId")}, 
            inverseJoinColumns = { @JoinColumn(name = "cardId")}
    )
    private List<Card> cards = new ArrayList<>();
    
    @OneToMany
    private List<Review> reviews = new ArrayList<>();

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.deckId;
        hash = 89 * hash + Objects.hashCode(this.deckName);
        hash = 89 * hash + Objects.hashCode(this.deckDesc);
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
        return true;
    }

}
