/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.controller;

import com.sg.flashcardapp.dao.CardRepository;
import com.sg.flashcardapp.model.Card;
import com.sg.flashcardapp.service.FlashCardService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author annamaxam
 */
@RestController
public class CardController {

    @Autowired
//    private CardRepository cards;
    private FlashCardService service;

    @GetMapping(value = "/card/{id}")
    public Card getCard(@PathVariable("id") int id) {
//        return cards.findOne(id);
        return service.getCard(id);
    }

    @PostMapping(value = "/card")
    @ResponseStatus(HttpStatus.CREATED)
    public Card createCard(@Valid @RequestBody Card card) {
//        return cards.save(card);
        return service.createCard(card);
    }

    @DeleteMapping(value = "/card/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCard(@PathVariable("id") int id) {
//        cards.delete(id);
        service.deleteCard(id);
    }

    @PutMapping(value = "/card/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Card updateCard(@PathVariable("id") int id, @Valid @RequestBody Card card) throws UpdateIntegrityException {
        // favor the path variable over the id in the object if they differ
        if (id != card.getCardId()) {
            throw new UpdateIntegrityException("Card Id on URL must match Card Id in submitted data.");
        }
//        return cards.save(card);
        return service.updateCard(id, card);

//        return card;
    }

    @GetMapping(value = "/cards")
    public List<Card> getAllCards() {
//        return cards.findAll();
        return service.getAllCards();
    }
    
     //@GetMapping(value = "/cards/deck/{id}")
    
    
}
