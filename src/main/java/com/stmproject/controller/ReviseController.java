package com.stmproject.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.stmproject.model.STM;
import com.stmproject.service.ReviseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ReviseController {

	private static final Logger logger = LoggerFactory.getLogger(ReviseController.class);

	@Autowired
	private ReviseService reviseService;

//	@Autowired
//	private M_UserService userService;

	@GetMapping("/revise/{id}")
	public String reviewSTM(@PathVariable String id, Model model, HttpSession session,
			@RequestParam(value = "ssoid", required = false) String ssoid) {
		// M_User user = userService.findBySsoid(ssoid);
		System.out.println(ssoid);
		STM stm = reviseService.getSTMById(id);
		model.addAttribute("stm", stm);
		model.addAttribute("ssoid", ssoid);
		model.addAttribute("ssoid", session.getAttribute("username"));
		// System.out.println(stm.getCreatorSSOID());
		return "ReviseScreen";
	}

	@PostMapping("/revise")
	public String updateSTM(@ModelAttribute STM updatedSTM, BindingResult result, Model model,
			@RequestParam(value = "pdfFile", required = false) MultipartFile pdfFile,
			@RequestParam(value = "wordFile", required = false) MultipartFile wordFile,
			@RequestParam(value = "ssoid", required = false) String ssoid) throws IOException {

		logger.info("Updating STM: {}", updatedSTM);
		System.out.println(updatedSTM);
		System.out.println(updatedSTM.getStmNo());

		try {
			// Update the STM with the provided STM Number
			reviseService.updateSTM(updatedSTM, pdfFile, wordFile,ssoid);

			// Retrieve the updated STM
			STM stm = reviseService.getSTMById(updatedSTM.getStmNo());

			// Add success message to the model
			model.addAttribute("successMessage", "STM Revised successfully!");
			model.addAttribute("stm", stm);
		} catch (Exception e) {
			// Add error message to the model
			logger.error("Failed to update STM. STM Number: {}", updatedSTM.getStmNo(), e);
			model.addAttribute("errorMessage", "Failed to Revised STM. Please try again.");
			e.printStackTrace();
		}
		model.addAttribute("ssoid", ssoid);
		return "ReviseScreen";
	}

}
