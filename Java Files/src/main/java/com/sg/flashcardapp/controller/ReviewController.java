/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.controller;

import com.sg.flashcardapp.model.Review;
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
 * @author betzler
 */
@RestController
public class ReviewController {

    @Autowired
    private FlashCardService service;

    @GetMapping(value = "/review/{id}")
    public Review getReview(@PathVariable("id") int id) {
        return service.getReview(id);
    }

    @PostMapping(value = "/review")
    @ResponseStatus(HttpStatus.CREATED)
    public Review createReview(@Valid @RequestBody Review review) {
        return service.createReview(review);
    }

    @DeleteMapping(value = "/review/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable("id") int id) {
        service.deleteReview(id);
    }

    @PutMapping(value = "/review/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Review updateReview(@PathVariable("id") int id, @Valid @RequestBody Review review) throws UpdateIntegrityException {
        // favor the path variable over the id in the object if they differ
        if (id != review.getReviewId()) {
            throw new UpdateIntegrityException("Review Id on URL must match Review Id in submitted data.");
        }

        return service.updateReview(id, review);
    }

    @GetMapping(value = "/reviews")
    public List<Review> getAllReviews() {
        return service.getAllReviews();
    }
}
