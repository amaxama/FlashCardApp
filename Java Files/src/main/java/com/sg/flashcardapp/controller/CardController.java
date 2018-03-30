/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.controller;

import com.sg.flashcardapp.dao.CardRepository;
import com.sg.flashcardapp.model.Card;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author annamaxam
 */
public class CardController {

    @Autowired
    private CardRepository cards;

    @RequestMapping(value = "/card/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Card getCard(@PathVariable("id") int id) {
        return cards.findOne(id);
    }

    @RequestMapping(value = "/card", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Card createCard(@Valid @RequestBody Card card) {
        return cards.save(card);
    }

    @RequestMapping(value = "/card/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCard(@PathVariable("id") int id) {
        cards.delete(id);
    }

    @RequestMapping(value = "/card/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Card updateCard(@PathVariable("id") int id, @Valid @RequestBody Card card) throws UpdateIntegrityException {
        // favor the path variable over the id in the object if they differ
        if (id != card.getCardId()) {
            throw new UpdateIntegrityException("Card Id on URL must match Card Id in submitted data.");
        }
        cards.save(card);
        
        return card;
    }

    @RequestMapping(value = "/cards", method = RequestMethod.GET)
    @ResponseBody
    public List<Card> getAllCards() {
        return cards.findAll();
    }
}
