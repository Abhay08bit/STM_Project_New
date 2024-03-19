package com.stmproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stmproject.model.M_User;
import com.stmproject.repository.M_UserRepository;

@Controller
public class DashBoardController {
	
	@Autowired
	private M_UserRepository userRepository;
	
	@GetMapping("/dashboard")
	public String showDashboard(Model model, @RequestParam("ssoid") String ssoid) {	   
		M_User user=userRepository.findBySsoid(ssoid);
		Character userType=user.getUser_Type();
	   

	    // Redirect to the appropriate dashboard based on the condition
		if (userType != null && userType.equals('A')) {
			model.addAttribute("ssoid", ssoid);
	        return "AdminDashBoard";
	    } else {
	    	model.addAttribute("ssoid", ssoid);
	        return "UserDashBoard";
	    }
		
	}

	@GetMapping("/return")
	public String returnToLogin() {
		return "LoginScreen";
	}

	// Redirect to SearchPage

	@GetMapping("/modify")
	public String returnToAdminDashboardModify(Model model,@RequestParam("ssoid") String ssoid) {
		model.addAttribute("ssoid", ssoid);
		return "SearchPage";
	}

	// Redirect to SearchPage
	@GetMapping("/revise")
	public String returnToAdminDashboardRevise(Model model,@RequestParam("ssoid") String ssoid) {
		model.addAttribute("ssoid", ssoid);
		return "SearchPage";
	}

	// Redirect to SearchPage
	@GetMapping("/delete")
	public String returnToAdminDashboardDelete(Model model,@RequestParam("ssoid") String ssoid) {
		model.addAttribute("ssoid", ssoid);
		return "SearchPage";
	}

	@GetMapping("/view")
	public String returnToView(Model model,@RequestParam("ssoid") String ssoid) {
		model.addAttribute("ssoid", ssoid);
		return "UserView";
	}
	
	@GetMapping("/searchPage")
	public String returnToSearchPage(Model model,@RequestParam("ssoid") String ssoid) {
		model.addAttribute("ssoid", ssoid);
		System.out.println(ssoid);
		return "SearchPage";
	}

}
