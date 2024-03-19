package com.stmproject.controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
	
	
	    @ExceptionHandler(Exception.class)
	    public String handleException(Exception e, Model model) {
	        // Add custom exception information to the model if needed
	        model.addAttribute("error", "An unexpected error occurred.");
                System.out.println("error");
	        // Return the name of your Thymeleaf error template
	        return "error";
	    }
	}


