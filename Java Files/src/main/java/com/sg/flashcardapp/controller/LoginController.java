/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.controller;

import com.sg.flashcardapp.model.User;
import com.sg.flashcardapp.service.FlashCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author annamaxam
 */
@Controller
public class LoginController {
    
    @Autowired
    private FlashCardService service;
    
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    
    @GetMapping("/currentuser/userId")
    @ResponseBody
    public int currentUserId(Authentication authentication) {
        String username = authentication.getName();
        int id = service.getUserId(username);
        return id;
//        User user = (User) authentication.getPrincipal();
//        String id = Integer.toString(user.getUserId());
//        return id;
    }
    
    
    
    
    
    
//    <c:if test="${pageContext.request.userPrincipal.name != null}">
//    <h4>Hello : ${pageContext.request.userPrincipal.name}
//        | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
//    </h4>
//    </c:if>
    
    
//    In html navigation bar, will just put an <a href= "/j_spring_security_logout">Log Out</a>
    
    
//    Create restful endpoint that checks to see if user is longed in 
//    Idea of Principal - currently logged in user
//    Only show logout if get username back?
    
    
    
    
    
    
//    If user not allowed access to a route - spit back out and ask to login, authenticatiion measures happen with intercept urls 
    // if want to do limit access to 
//    Backend checks role of prinicipla - if role is user, add and delete button do one thing
//     if role is admin, buttons do a different thing
//    home page is same for anonymous, logged in and admin, 
//    admin has additional inbox page for reviewing
}
