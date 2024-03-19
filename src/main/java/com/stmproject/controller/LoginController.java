package com.stmproject.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.stmproject.model.M_User;
import com.stmproject.service.M_UserService;
import java.net.URLEncoder;


@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private M_UserService userService;

	@GetMapping("/login")
	public String showLoginForm() {
		return "LoginScreen";
	}

	@PostMapping("/login")
	public String login(@RequestParam("ssoid") String ssoid, @RequestParam("password") String password, Model model) {
	    logger.info("Received ssoid in login: {}", ssoid);

	    M_User user = userService.findBySsoid(ssoid);
	    if (user != null && password.equals(user.getPassword())) {
	    	
	    	if (user.isIs_Deleted()) {
	    	    logger.warn("Login failed for ssoid: {}", ssoid);
	    	    model.addAttribute("accountDeleted", true);
	    	    return "LoginScreen";
	    	}
	    	
	        if (user.getUser_Type().equals('A')) {
	            logger.info("Admin login successful: {}", ssoid);

	            String encodedSsoid;
	            try {
	                encodedSsoid = URLEncoder.encode(ssoid, StandardCharsets.UTF_8.toString());
	            } catch (UnsupportedEncodingException e) {
	                // Handle encoding exception if necessary
	                logger.error("Error encoding ssoid: {}", e.getMessage());
	                return "errorPage";
	            }

	            String redirectUri = "redirect:/AdminDashBoard?ssoid=" + encodedSsoid;
	            logger.info("Redirecting to: {}", redirectUri);

	            return redirectUri;
	        } else if (user.getUser_Type().equals('N')) {
	        	String encodedUSsoid = URLEncoder.encode(ssoid, StandardCharsets.UTF_8);
	            logger.info("User login successful: {}", ssoid);
	            return "redirect:/UserDashBoard?ssoid=" + encodedUSsoid;
	        }
	    }

	    logger.warn("Login failed for ssoid: {}", ssoid);
	    model.addAttribute("invalidCredentials", true);
	    return "LoginScreen";
	}




	@GetMapping("/AdminDashBoard")
	public String adminDashboard(@RequestParam("ssoid") String ssoid, Model model) throws UnsupportedEncodingException {	    
	    model.addAttribute("ssoid", URLDecoder.decode(ssoid, StandardCharsets.UTF_8.toString()));
	    return "AdminDashBoard";
	}


	@GetMapping("/UserDashBoard")
	public String userDashboard(@RequestParam("ssoid") String ssoid, Model model) throws UnsupportedEncodingException {
		 model.addAttribute("ssoid", URLDecoder.decode(ssoid, StandardCharsets.UTF_8.toString()));
	    return "UserDashBoard";
	}

	

}
