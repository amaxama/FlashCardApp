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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author annamaxam
 */
@RestController
public class DeckController {

    @Autowired
    private DeckRepository decks;

    @GetMapping(value = "/deck/{id}")
    public Deck getDeck(@PathVariable("id") int id) {
        return decks.findOne(id);
    }

    @PostMapping(value = "/deck")
    @ResponseStatus(HttpStatus.CREATED)
    public Deck createContact(@Valid @RequestBody Deck deck) {
        return decks.save(deck);
    }

    @DeleteMapping(value = "/deck/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDeck(@PathVariable("id") int id) {
        decks.delete(id);
    }

    @PutMapping(value = "/deck/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Deck updateDeck(@PathVariable("id") int id, @Valid @RequestBody Deck deck) throws UpdateIntegrityException {
        // favor the path variable over the id in the object if they differ
        if (id != deck.getDeckId()) {
            throw new UpdateIntegrityException("Deck Id on URL must match Deck Id in submitted data.");
        }
        decks.save(deck);
        
        return deck;
    }

    @GetMapping(value = "/decks")
    public List<Deck> getAllDecks() {
        return decks.findAll();
    }

}
