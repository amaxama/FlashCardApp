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
import javax.persistence.ManyToOne;

/**
 *
 * @authors Mike Betzler, Jacob Duerr, Anna Maxam, Jeff Peterson
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Folder {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private int folderId;

    @Column(nullable = false)
    private String folderName;

    
//    COME BACK TO - MAY NEED USERID AS COLUMN
    @ManyToOne
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "DeckFolder",
            joinColumns = {@JoinColumn(name = "deckId")}, 
            inverseJoinColumns = { @JoinColumn(name = "folderId")}
    )
    @JsonIgnore
    private List<Deck> decks = new ArrayList<>();

    public Folder() {

    }

    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public void setDecks(List<Deck> decks) {
        this.decks = decks;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.folderId;
        hash = 31 * hash + Objects.hashCode(this.folderName);
        hash = 31 * hash + Objects.hashCode(this.user);
        hash = 31 * hash + Objects.hashCode(this.decks);
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
        final Folder other = (Folder) obj;
        if (this.folderId != other.folderId) {
            return false;
        }
        if (!Objects.equals(this.folderName, other.folderName)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.decks, other.decks)) {
            return false;
        }
        return true;
    }

    

}
