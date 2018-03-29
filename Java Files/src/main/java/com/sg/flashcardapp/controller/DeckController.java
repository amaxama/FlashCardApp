/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.controller;

import com.sg.flashcardapp.dao.DeckRepository;
import com.sg.flashcardapp.model.Deck;
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
public class DeckController {

    @Autowired
    private DeckRepository decks;

    @RequestMapping(value = "/deck/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Deck getDeck(@PathVariable("id") int id) {
        return decks.findOne(id);
    }

    @RequestMapping(value = "/deck", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Deck createContact(@Valid @RequestBody Deck deck) {
        return decks.save(deck);
    }

    @RequestMapping(value = "/deck/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDeck(@PathVariable("id") int id) {
        decks.delete(id);
    }

    @RequestMapping(value = "/deck/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDEck(@PathVariable("id") int id, @Valid @RequestBody Deck deck) throws UpdateIntegrityException {
        // favor the path variable over the id in the object if they differ
        if (id != deck.getDeckId()) {
            throw new UpdateIntegrityException("Deck Id on URL must match Deck Id in submitted data.");
        }
        decks.save(deck);
    }

    @RequestMapping(value = "/decks", method = RequestMethod.GET)
    @ResponseBody
    public List<Deck> getAllDecks() {
        return decks.findAll();
    }

}
