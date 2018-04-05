/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.controller;

import com.sg.flashcardapp.model.User;
import com.sg.flashcardapp.service.FlashCardService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
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
@RestController //for security sake - okay to have restcontroller, not just controller?
public class UserController {

    @Autowired
    private FlashCardService service;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable("id") int id) {
        return service.getUser(id);
    }

    @PostMapping(value = "/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody User user) {
        User newUser = user;
        String clearPw = user.getPassword();
        String hashPw = encoder.encode(clearPw);
        newUser.setPassword(hashPw);
        newUser.addRole(service.getRoleByName("ROLE_USER"));
        newUser.setActive(true);;
        return service.createUser(user);

//        Treat user as if already finished - set role in ajax call 
        // All users have ROLE_USER, only add ROLE_ADMIN if the isAdmin 
        // box is checked
//        newUser.addAuthority("ROLE_USER");
//        if (null != req.getParameter("isAdmin")) {
//            newUser.addAuthority("ROLE_ADMIN");
    }

    @DeleteMapping(value = "/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") int id) {
        service.deleteUser(id);
    }

    @PutMapping(value = "/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public User updateUser(@PathVariable("id") int id, @Valid @RequestBody User user) throws UpdateIntegrityException {
        // favor the path variable over the id in the object if they differ
        if (id != user.getUserId()) {
            throw new UpdateIntegrityException("User Id on URL must match User Id in submitted data.");
        }

        return service.updateUser(id, user);
    }

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

}
