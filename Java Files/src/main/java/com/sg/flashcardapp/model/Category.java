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
/**
 *
 * @authors Mike Betzler, Jacob Duerr, Anna Maxam, Jeff Peterson
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private int categoryId;
    
    @Column(nullable = false)
    private String categoryName;
    
    @Column
    private String categoryDesc;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "CardCategory",
            joinColumns = {@JoinColumn(name = "categoryId")}, 
            inverseJoinColumns = { @JoinColumn(name = "cardId")}
    )
    @JsonIgnore
    private List<Card> cards = new ArrayList<>();
    

  public Category() {
    
  }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.categoryId;
        hash = 89 * hash + Objects.hashCode(this.categoryName);
        hash = 89 * hash + Objects.hashCode(this.categoryDesc);
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
        final Category other = (Category) obj;
        if (this.categoryId != other.categoryId) {
            return false;
        }
        if (!Objects.equals(this.categoryName, other.categoryName)) {
            return false;
        }
        if (!Objects.equals(this.categoryDesc, other.categoryDesc)) {
            return false;
        }
        return true;
    }
  
  
    
  
}
