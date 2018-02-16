package com.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This is what makes the class as rest controller
@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String home(){
		return "Spring-boot REST service reporting for duty!!";
	}
	

}
