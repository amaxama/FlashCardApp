/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.controller;

import com.sg.flashcardapp.dao.CategoryRepository;
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
    private CategoryRepository categories;

    @GetMapping(value = "/category/{id}")
    public Category getCategory(@PathVariable("id") int id) {
        return categories.findOne(id);
    }

    @PostMapping(value = "/category")
    @ResponseStatus(HttpStatus.CREATED)
    public Category createCategory(@Valid @RequestBody Category category) {
        return categories.save(category);
    }

    @DeleteMapping(value = "/category/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable("id") int id) {
        categories.delete(id);
    }

    @PutMapping(value = "/category/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Category updateCategory(@PathVariable("id") int id, @Valid @RequestBody Category category) throws UpdateIntegrityException {
        // favor the path variable over the id in the object if they differ
        if (id != category.getCategoryId()) {
            throw new UpdateIntegrityException("Card Id on URL must match Card Id in submitted data.");
        }
        categories.save(category);

        return category;
    }

    @GetMapping(value = "/categories")
    public List<Category> getAllCards() {
        return categories.findAll();
    }

}
