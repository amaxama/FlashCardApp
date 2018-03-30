/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.controller;

import com.sg.flashcardapp.dao.UserRepository;
import com.sg.flashcardapp.model.User;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author annamaxam
 */
@RestController //for security sake - okay to have restcontroller, not just controller?
public class UserController {

    @Autowired
    private UserRepository users;
    
    @Autowired
    private PasswordEncoder encoder;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("id") int id) {
        return users.findOne(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public User createUser(@Valid @RequestBody User user) {
        User newUser = user;
        String clearPw = user.getPassword();
        String hashPw = encoder.encode(clearPw);
        newUser.setPassword(hashPw);
        return users.save(user);
        
//        Treat user as if already finished - set role in ajax call 
        
        // All users have ROLE_USER, only add ROLE_ADMIN if the isAdmin 
        // box is checked
//        newUser.addAuthority("ROLE_USER");
//        if (null != req.getParameter("isAdmin")) {
//            newUser.addAuthority("ROLE_ADMIN");
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") int id) {
        users.delete(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable("id") int id, @Valid @RequestBody User user) throws UpdateIntegrityException {
        // favor the path variable over the id in the object if they differ
        if (id != user.getUserId()) {
            throw new UpdateIntegrityException("Contact Id on URL must match Contact Id in submitted data.");
        }
        users.save(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        return users.findAll();
    }
    

}
