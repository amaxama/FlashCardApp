/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 *
 * @authors Mike Betzler, Jacob Duerr, Anna Maxam, Jeff Peterson
 */
@Entity
@IdClass(CompositeKeyRating.class)
public class CardRating {
    
    @Id
    private int userId;
    @Id
    private int cardId;
    
    
    
    @Column(nullable = false)
    private Integer rating;
    
    
}
