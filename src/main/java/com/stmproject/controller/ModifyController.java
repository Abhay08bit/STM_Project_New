package com.stmproject.controller;

import java.io.IOException;

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
import org.springframework.web.multipart.MultipartFile;

import com.stmproject.model.STM;

import com.stmproject.service.ModifyService;


@Controller
public class ModifyController {

	private static final Logger logger = LoggerFactory.getLogger(ModifyController.class);
	@Autowired
	private ModifyService modifyService;

	@GetMapping("modify/{stmNo}")
	public String ModifyPage(@PathVariable String stmNo, Model model,HttpSession session) {
		STM stm = modifyService.getSTMByStmNoQuery(stmNo);
		model.addAttribute("stm", stm);
		model.addAttribute("ssoid", session.getAttribute("username"));
		return "ModifyScreen";
	}

	
	@PostMapping("/modify")
    public String modifySTM(@ModelAttribute("stm") STM modifySTM, BindingResult result, Model model,
            @RequestParam(value = "pdfFile", required = false) MultipartFile pdfFile,
            @RequestParam(value = "wordFile", required = false) MultipartFile wordFile,
            @RequestParam(value = "ssoid", required = false) String ssoid) throws IOException {
        System.out.println(modifySTM);
        System.out.println(modifySTM.getStmNo());

        try {
            // Modify the STM with the provided STM Number
            modifyService.modifySTM(modifySTM, pdfFile, wordFile,ssoid);

            // Retrieve the updated STM
            STM stm = modifyService.getSTMByStmNoQuery(modifySTM.getStmNo());

            // Add success message to the model
            model.addAttribute("message", "STM modified successfully!");
            model.addAttribute("stm", stm);

            // Log successful modification
            logger.info("STM modification successful. STM number: {}", modifySTM.getStmNo());
        } catch (Exception e) {
            // Add error message to the model
            model.addAttribute("error", "Failed to modify STM. Please try again.");

            // Log the error
            logger.error("Error occurred during STM modification.", e);
            e.printStackTrace();
        }
        model.addAttribute("ssoid", ssoid);
        return "ModifyScreen";
    }
		
	@GetMapping("/returnSearchPage")
	public String returnToSearchPage(@RequestParam("ssoid") String ssoid,Model model) {
		model.addAttribute("ssoid", ssoid);
		return "SearchPage";
	}
	
	
}
