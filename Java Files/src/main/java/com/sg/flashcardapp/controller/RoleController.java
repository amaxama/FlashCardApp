/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.controller;

import com.sg.flashcardapp.dao.RoleRepository;
import com.sg.flashcardapp.model.Role;
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
public class RoleController {

    @Autowired
    private FlashCardService service;

    @GetMapping(value = "/role/{id}")
    public Role getRole(@PathVariable("id") int id) {
        return service.getRole(id);
    }

    @PostMapping(value = "/role")
    @ResponseStatus(HttpStatus.CREATED)
    public Role createRole(@Valid @RequestBody Role role) {
        return service.createRole(role);
    }

    @DeleteMapping(value = "/role/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRole(@PathVariable("id") int id) {
        service.deleteRole(id);
    }

    @PutMapping(value = "/role/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Role updateRole(@PathVariable("id") int id, @Valid @RequestBody Role role) throws UpdateIntegrityException {
        // favor the path variable over the id in the object if they differ
        if (id != role.getRoleId()) {
            throw new UpdateIntegrityException("Card Id on URL must match Card Id in submitted data.");
        }

        return service.updateRole(id, role);
    }

    @GetMapping(value = "/roles")
    public List<Role> getAllRoles() {
        return service.getAllRoles();
    }

}
