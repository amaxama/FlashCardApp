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
public class CategoryController {

    @Autowired
    private CategoryRepository categories;

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Category getCategory(@PathVariable("id") int id) {
        return categories.findOne(id);
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Category createCategory(@Valid @RequestBody Category category) {
        return categories.save(category);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable("id") int id) {
        categories.delete(id);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCategory(@PathVariable("id") int id, @Valid @RequestBody Category category) throws UpdateIntegrityException {
        // favor the path variable over the id in the object if they differ
        if (id != category.getCategoryId()) {
            throw new UpdateIntegrityException("Category Id on URL must match Category Id in submitted data.");
        }
        categories.save(category);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    @ResponseBody
    public List<Category> getAllCategories() {
        return categories.findAll();
    }

}
