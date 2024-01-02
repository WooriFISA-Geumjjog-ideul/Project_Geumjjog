package com.geumjjok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/login")
    public String home() {
    	System.out.println("login *** ");
        return "member/login";	//WEB-INF/jsp/login.jsp
    }
    
    @GetMapping("/signup")
    public String signup() {
    	System.out.println("signup *** ");
    	return "member/signup";	//WEB-INF/jsp/signup.jsp
    }
    
    @GetMapping("/findpassword")
    public String findPassword() {
    	System.out.println("findpassword *** ");
    	return "member/findpassword";	//WEB-INF/jsp/signup.jsp
    }
    
    @GetMapping("/list")
    public String post() {
    	System.out.println("post *** ");
    	return "post/list";	//WEB-INF/jsp/post/list.jsp
    }
}
