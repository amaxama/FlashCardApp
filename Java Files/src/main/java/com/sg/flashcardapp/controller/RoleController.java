/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.controller;

import com.sg.flashcardapp.dao.RoleRepository;
import com.sg.flashcardapp.model.Role;
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
public class RoleController {

    @Autowired
    private RoleRepository roles;

    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Role getRole(@PathVariable("id") int id) {
        return roles.findOne(id);
    }

    @RequestMapping(value = "/role", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Role createRole(@Valid @RequestBody Role role) {
        return roles.save(role);
    }

    @RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRole(@PathVariable("id") int id) {
        roles.delete(id);
    }

    @RequestMapping(value = "/role/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Role updateRole(@PathVariable("id") int id, @Valid @RequestBody Role role) throws UpdateIntegrityException {
        // favor the path variable over the id in the object if they differ
        if (id != role.getRoleId()) {
            throw new UpdateIntegrityException("Card Id on URL must match Card Id in submitted data.");
        }
        roles.save(role);

        return role;
    }

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    @ResponseBody
    public List<Role> getAllRoles() {
        return roles.findAll();
    }

}
