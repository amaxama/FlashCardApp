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
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private int userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean active;

    @ManyToMany
    @JoinTable(name= "UserRole",
            joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "deckId")}
    )
    List<Role> roles = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(name = "UserDeck",
            joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "deckId")}
    )
    List<Deck> decks = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(name="userCard", 
    joinColumns={ @JoinColumn(name = "userId") },
    inverseJoinColumns={ @JoinColumn(name = "cardId") } 
    )
    List<Card> cards = new ArrayList<>();

    @OneToMany
    List<Review> reviews = new ArrayList<>();
    
    @OneToMany
    List<CardRating> ratings = new ArrayList<>();

    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public void setDecks(List<Deck> decks) {
        this.decks = decks;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<CardRating> getRatings() {
        return ratings;
    }

    public void setRatings(List<CardRating> ratings) {
        this.ratings = ratings;
    }

    
    
    public void addRole(Role role) {
        roles.add(role);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.userId;
        hash = 37 * hash + Objects.hashCode(this.userName);
        hash = 37 * hash + Objects.hashCode(this.password);
        hash = 37 * hash + (this.active ? 1 : 0);
        hash = 37 * hash + Objects.hashCode(this.roles);
        hash = 37 * hash + Objects.hashCode(this.decks);
        hash = 37 * hash + Objects.hashCode(this.cards);
        hash = 37 * hash + Objects.hashCode(this.reviews);
        hash = 37 * hash + Objects.hashCode(this.ratings);
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
        final User other = (User) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.active != other.active) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        if (!Objects.equals(this.decks, other.decks)) {
            return false;
        }
        if (!Objects.equals(this.cards, other.cards)) {
            return false;
        }
        if (!Objects.equals(this.reviews, other.reviews)) {
            return false;
        }
        if (!Objects.equals(this.ratings, other.ratings)) {
            return false;
        }
        return true;
    }

    

}
