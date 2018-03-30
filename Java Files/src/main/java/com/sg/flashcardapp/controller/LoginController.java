/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flashcardapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author annamaxam
 */
@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
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
