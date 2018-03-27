package com.sg.flashcardapp.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/"})
public class HomeController {
        
    public HomeController() {
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String method(Map<String, Object> model) {
        
        return "index";
    }
}
