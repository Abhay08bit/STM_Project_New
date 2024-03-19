package com.stmproject.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stmproject.model.STM;
import com.stmproject.service.DeleteService;
import com.stmproject.service.ReviseService;

@Controller
public class DeleteController {

	private static final Logger logger = LoggerFactory.getLogger(DeleteController.class);
	@Autowired
	private DeleteService deleteService;

	@Autowired
	private ReviseService reviseService;

	@GetMapping("/delete/{id}")
	public String reviewSTM(@PathVariable String id, Model model, HttpSession session) {
		STM stm = reviseService.getSTMById(id);
		model.addAttribute("stm", stm);
		model.addAttribute("ssoid", session.getAttribute("username"));
		return "DeleteScreen";
	}

	@PostMapping("/delete")
	public String deleteStm(@ModelAttribute("stm") STM stm, BindingResult result, Model model,@RequestParam(value = "ssoid", required = false) String ssoid) {
		try {
			boolean isDeleted = deleteService.isDeleteStm(stm.getStmNo());
			System.out.println(stm.getStmNo());

			if (isDeleted) {
				model.addAttribute("message", "STM deleted successfully!");

				// Log successful deletion
				logger.info("STM deletion successful. STM number: {}", stm.getStmNo());
				model.addAttribute("ssoid", ssoid);
				return "SearchPage";
				
			} else {
				model.addAttribute("error", "STM not found. Deletion failed.");

				// Log deletion failure
				logger.error("STM deletion failed. STM number: {}", stm.getStmNo());
				return "DeleteScreen";
			}
		} catch (Exception e) {
			// Add error message to the model
			model.addAttribute("error", "Failed to delete STM. Please try again.");

			// Log the error
			logger.error("Error occurred during STM deletion.", e);
			e.printStackTrace();

		}		
		return "SearchPage";
	}

}
