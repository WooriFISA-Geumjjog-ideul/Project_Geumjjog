package com.geumjjok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/login")
    public String home() {
    	System.out.println("++++++++++++++");
        return "index";	//WEB-INF/jsp/index.jsp
    }
    @GetMapping("/signup")
    public String signup() {
    	System.out.println("signup *** ");
    	return "signup";	//WEB-INF/jsp/index.jsp
    }
}
