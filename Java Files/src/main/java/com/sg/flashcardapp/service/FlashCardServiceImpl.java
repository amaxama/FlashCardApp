/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.service;

import com.sg.flashcardapp.dao.CardRepository;
import com.sg.flashcardapp.model.Card;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author betzler
 */
@Component
public class FlashCardServiceImpl implements FlashCardService {
    
        @Autowired
    private CardRepository cards;
    
    public    Card getCard(int id) {
        return cards.findOne(id);
    }
    
    public Card createCard(Card card) {
        return cards.save(card);
    }
    
    public void deleteCard(int id) {
        cards.delete(id);
    }
    
    public Card updateCard(int id, Card card) {
        cards.save(card);
        
        return card;
    }
    
    public List<Card> getAllCards() {
        return cards.findAll();
    }
}
