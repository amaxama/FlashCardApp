/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.controller;

import com.sg.flashcardapp.dao.CardRatingRepository;
import com.sg.flashcardapp.dao.CategoryRepository;
import com.sg.flashcardapp.model.CardRating;
import com.sg.flashcardapp.model.Category;
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
 * @authors Mike Betzler, Jacob Duerr, Anna Maxam, Jeff Peterson
 */
@RestController
public class CardRatingController {

    @Autowired
    private CardRatingRepository cardRatings;

    @GetMapping(value = "/cardrating/{id}")
    public CardRating getCardRating(@PathVariable("id") int id) {
        return cardRatings.findOne(id);
    }

    @PostMapping(value = "/cardrating")
    @ResponseStatus(HttpStatus.CREATED)
    public CardRating createCardRating(@Valid @RequestBody CardRating cardRating) {
        return cardRatings.save(cardRating);
    }

    @DeleteMapping(value = "/cardrating/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCardRating(@PathVariable("id") int id) {
        cardRatings.delete(id);
    }

    @PutMapping(value = "/cardrating/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public CardRating updateCardRating(@PathVariable("id") int id, @Valid @RequestBody CardRating cardRating) throws UpdateIntegrityException {
        // favor the path variable over the id in the object if they differ
        if (id != cardRating.getCardId()) {
            throw new UpdateIntegrityException("Card Id on URL must match Card Id in submitted data.");
        }
        cardRatings.save(cardRating);

        return cardRating;
    }

    @GetMapping(value = "/cardratings")
    public List<CardRating> getAllCardRatings() {
        return cardRatings.findAll();
    }

}
