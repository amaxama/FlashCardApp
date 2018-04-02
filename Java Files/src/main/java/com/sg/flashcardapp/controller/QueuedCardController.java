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
import com.sg.flashcardapp.service.FlashCardService;

/**
 *
 * @authors Mike Betzler, Jacob Duerr, Anna Maxam, Jeff Peterson
 */
@RestController
public class QueuedCardController {
    
        @Autowired
    private FlashCardService service;

    @GetMapping(value = "/queuedcard/{id}")
    public QueuedCard getQueuedCard(@PathVariable("id") int id) {
        return service.getQueuedCard(id);
    }

    @PostMapping(value = "/queuedcard")
    @ResponseStatus(HttpStatus.CREATED)
    public QueuedCard createQueuedCard(@Valid @RequestBody QueuedCard queuedCard) {
        return service.createQueuedCard(queuedCard);
    }

    @DeleteMapping(value = "/queuedcard/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQueueCard(@PathVariable("id") int id) {
        service.deleteQueueCard(id);
    }

    @PutMapping(value = "/queuedcard/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public QueuedCard updateQueuedCard(@PathVariable("id") int id, @Valid @RequestBody QueuedCard queuedCard) throws UpdateIntegrityException {
        // favor the path variable over the id in the object if they differ
        if (id != queuedCard.getQueuedCardId()) {
            throw new UpdateIntegrityException("Card Id on URL must match Card Id in submitted data.");
        }
        
        return service.updateQueuedCard(id, queuedCard);
    }

    @GetMapping(value = "/queuedcards")
    public List<QueuedCard> getAllQueuedCards() {
        return service.getAllQueuedCards();
    }
}
