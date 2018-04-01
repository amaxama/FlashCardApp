/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.service;

import com.sg.flashcardapp.model.Card;
import java.util.List;

/**
 *
 * @authors Mike Betzler, Jacob Duerr, Anna Maxam, Jeff Peterson
 */
public interface FlashCardService {
    
    Card getCard(int id);
    
    Card createCard(Card card);
    
    void deleteCard(int id);
    
    Card updateCard(int id, Card card);
    
    List<Card> getAllCards();
  
}
