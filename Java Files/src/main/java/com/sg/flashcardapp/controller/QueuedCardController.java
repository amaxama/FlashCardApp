/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.controller;

import com.sg.flashcardapp.model.Card;
import com.sg.flashcardapp.model.QueuedCard;
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
import com.sg.flashcardapp.dao.QueuedCardRepository;

/**
 *
 * @authors Mike Betzler, Jacob Duerr, Anna Maxam, Jeff Peterson
 */
@RestController
public class QueuedCardController {
    
        @Autowired
    private QueuedCardRepository queuedcards;

    @GetMapping(value = "/queuedcard/{id}")
    public QueuedCard getQueuedCard(@PathVariable("id") int id) {
        return queuedcards.findOne(id);
    }

    @PostMapping(value = "/queuedcard")
    @ResponseStatus(HttpStatus.CREATED)
    public QueuedCard createQueuedCard(@Valid @RequestBody QueuedCard queuedcard) {
        return queuedcards.save(queuedcard);
    }

    @DeleteMapping(value = "/queuedcard/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQueueCard(@PathVariable("id") int id) {
        queuedcards.delete(id);
    }

    @PutMapping(value = "/queuedcard/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public QueuedCard updateQueuedCard(@PathVariable("id") int id, @Valid @RequestBody QueuedCard queuedcard) throws UpdateIntegrityException {
        // favor the path variable over the id in the object if they differ
        if (id != queuedcard.getQueuedCardId()) {
            throw new UpdateIntegrityException("Card Id on URL must match Card Id in submitted data.");
        }
        queuedcards.save(queuedcard);
        
        return queuedcard;
    }

    @GetMapping(value = "/queuedcards")
    public List<QueuedCard> getAllQueuedCards() {
        return queuedcards.findAll();
    }
}
