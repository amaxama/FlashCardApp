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
    
    
    
//    <!DOCTYPE html><html>    <head>        
//    <title>Flashcard App: Login</title>        
//    <!-- Bootstrap core CSS -->        
//    <link href="/FlashCardApp/css/bootstrap.min.css" rel="stylesheet">         
//    <style>            
//    #login-div {                
//    border-style: solid;                
//    border-color: rgba(54,100,139);                
//    display: block;                
//    margin: auto;                
//    width: 38%;                
//    background-color: rgba(184,206,217);                margin-top: 2%;            }                        #login-form-div {                margin-top: 3%;            }            #search-button {                background-color: rgba(236,253,255);                margin-left: 68%;                margin-bottom: 3%;            }                        #search-button:hover {                background-color: rgba(54,100,139);            }            h1, h2, h3 {                text-align: center;            }        </style>    </head>    <body>        <div class="container-fluid">            <h1>Flashcard App</h1>            <hr/>            <h2> Login Page </h2>                        <div class="row" id="login-div">                <div class="col-md-12" id="login-form-div">                    <form class="form-horizontal"                          role="form"                          method="post"                          action="j_spring_security_check">                        <div class="form-group">                            <label for="j_username" class="col-md-4 control-label">Username:</label>                            <div class="col-md-8">                                <input type="text"                                        class="form-control"                                        name="j_username"                                        placeholder="Username"/>                            </div>                        </div>                        <div class="form-group">                            <label for="j_password" class="col-md-4 control-label">Password:</label>                            <div class="col-md-8">                                <input type="text"                                        class="form-control"                                        name="j_password"                                        placeholder="Password"/>                            </div>                        </div>                        <div class="form-group">                            <div class="col-md-offset-4 col-md-8">                                <input type="submit"                                        class="btn btn-default"                                        id="search-button"                                        value="Login"/>                            </div>                        </div>                    </form>                </div>            </div>        </div>        <!-- Placed at the end of the document so the pages load faster -->        <script src="/FlashCardApp/js/jquery-3.1.1.min.js"></script>        <script src="/FlashCardApp/js/bootstrap.min.js"></script>    </body></html>
    
    
    
    
    
    
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
