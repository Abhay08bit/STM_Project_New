package com.stmproject.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.stmproject.model.STM;
import com.stmproject.model.SearchResultlist;
import com.stmproject.service.S_UserService;

@Controller
public class SearchController {

	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

	@Autowired
	public HttpSession session;

	@Autowired
	private S_UserService sUserService;

	@Value("${Empty_Record_Message}")
	private String failuereMsg;

	@Value("${Record_Message}")
	private String successMsg;

	public SearchController() {
	}

	@GetMapping("/search")
	public String searchPage(Model model, @RequestParam("ssoid") String ssoid) {
		model.addAttribute("STM", "1");
		model.addAttribute("ssoid", ssoid);
		session.setAttribute("username", ssoid);
		model.addAttribute("ssoid", session.getAttribute("username"));

		return "SearchPage";
	}

	// After Clicking Cancel button from Modify Page
	@SuppressWarnings("unchecked")
	@PostMapping("/goBackToSearchAfterResetClick")
	public String resetBtnClick(Model model) {
		List<STM> searchList = new ArrayList<>();
		searchList = (List<STM>) session.getAttribute("ListData");
		model.addAttribute("list", searchList);

		return "SearchPage";
	}

// After Clicking Search button from Search Page
	@PostMapping("/searchClick")
	public String searchBtnClick(Model model, @ModelAttribute SearchResultlist sDao,
			@RequestParam("ssoid") String ssoid) throws Exception {
		try {
			List<SearchResultlist> searchList = sUserService.getValuesBySetValue(sDao);
			model.addAttribute("list", searchList);

			if (!searchList.isEmpty()) {
				model.addAttribute("records", searchList.size() + " " + successMsg);
				logger.debug(searchList.size() + " " + successMsg);
			} else {
				model.addAttribute("records", failuereMsg);
				logger.debug(failuereMsg);
			}

			model.addAttribute("ssoid", ssoid);
			model.addAttribute("STM", "2");//stmNo
			model.addAttribute("stmnum",sDao.getStmNo());
			model.addAttribute("stmver",sDao.getStmVersion());
			model.addAttribute("linkDest",sDao.getLinkDestination());
			model.addAttribute("txtjp",sDao.getTextShortJP());
			model.addAttribute("txteng",sDao.getTextShortEN());
			model.addAttribute("startdate",sDao.getStartDraftDate());
			model.addAttribute("enddate",sDao.getEndDraftDate());
			model.addAttribute("final",sDao.getFinalDrafterName());
			model.addAttribute("oldstm",sDao.getOldSTMNumber());

			session.setAttribute("username", ssoid);
			session.setAttribute("ListData", searchList);

			return "SearchPage";
		} catch (Exception e) {
			logger.error("An error occurred in searchBtnClick", e);
			model.addAttribute("error", "Invalid day. Please enter a valid day for the selected month.");
			model.addAttribute("ssoid", ssoid);
			session.setAttribute("username", ssoid);
			return "SearchPage";
		}
	}

	@PostMapping("/viewClick")
	public String viewBtnClick(Model model, @RequestParam("ssoid") String ssoid)
			throws ClassNotFoundException, SQLException {
		try {
			// fetching Data from searchUerServiceImpl class
			List<SearchResultlist> searchList = sUserService.getAllValues();
			model.addAttribute("list", searchList);

			if (!searchList.isEmpty()) {
				model.addAttribute("records", searchList.size() + " " + successMsg);
				logger.debug(searchList.size() + " " + successMsg);
			} else {
				model.addAttribute("records", failuereMsg);
				logger.debug(failuereMsg);
			}

			model.addAttribute("ssoid", ssoid);
			model.addAttribute("STM", "2");
			session.setAttribute("ListData", searchList);
			session.setAttribute("username", ssoid);
			return "SearchPage";
		} catch (Exception e) {
			logger.error("An error occurred in viewBtnClick", e);
			model.addAttribute("error", "Failed to load SearchListData");
			return "SearchPage";
		}
	}

	@PostMapping("/doubleClickTableRow")
	public String getModifyTableRowData(@RequestBody SearchResultlist dao, Model model) {
		try {
			@SuppressWarnings("unchecked")
			List<SearchResultlist> searchList = (List<SearchResultlist>) session.getAttribute("ListData");

			for (SearchResultlist ent : searchList) {
				if (ent.getRowIndex() == dao.getRowIndex()) {
					System.out.println(ent);
					session.setAttribute("modifyRowData", ent);
					break;
				}
			}
			model.addAttribute("ssoid", session.getAttribute("username"));
			model.addAttribute("STM", "2");
			return "ModifySearchData";
		} catch (Exception e) {
			logger.error("An error occurred in getModifyTableRowData", e);
			model.addAttribute("error", "Failed to get TableRow Data");
			return "ModifySearchData";
		}
	}
	
	@GetMapping("/Modify")
	public String ModifyViewPage(HttpSession session, Model model) {
		try {
		SearchResultlist modifyUser = sUserService
				.setEmptyForNullValues((SearchResultlist) session.getAttribute("modifyRowData"));
		
		// ADD[S]
		SearchResultlist result=sUserService.findBySTMNo(modifyUser.getStmNo());
		
		if(result!=null)
		{
			model.addAttribute("entValue", result);
			model.addAttribute("msgvalue", "");
		}
		else
		{
			SearchResultlist user=new SearchResultlist();
			user.setStmVersion("");
			user.setLinkDestination("");
			user.setTextShortEN("");
			user.setTextShortJP("");
			user.setPdfFile("");
			user.setWordFile("");
			user.setDraftingDate("");
			user.setOldSTMNumber("");
			user.setRemarks1("");
			user.setNote2("");
			user.setNote3("");
			
			model.addAttribute("entValue", user);
			model.addAttribute("msgvalue", "The STM No "+modifyUser.getStmNo()+" is already Deleted");
		}
		// ADD[E]
	
		String userId = (String) session.getAttribute("username");
		model.addAttribute("ssoid", userId);
		boolean isadminuser = sUserService.isAdminLogin(userId);
		if (isadminuser && result!=null) {
			model.addAttribute("enableBtn", 1);
		}
		return "ModifySearchData";
	}  catch (Exception e) {
        logger.error("An error occurred in ModifyViewPage", e);
        model.addAttribute("error", "An error occurred while loading data");
        return "ModifySearchData"; 
    }
}	
	@CrossOrigin
	@GetMapping("/downloadattachmentpdf")
	public ResponseEntity<byte[]> downloadFile(@RequestParam("file") String fileName, Model model) throws IOException {

		String filePath = "C:/STM_File/STM_File/" + fileName;
		Path path = Paths.get(filePath);
		
		byte[] fileContent = Files.readAllBytes(path);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData("attachment", fileName);

		return new ResponseEntity<>(fileContent, headers, org.springframework.http.HttpStatus.OK);
	}

	@GetMapping("/generateWord")
	public ResponseEntity<byte[]> downloadWordFile(@RequestParam("file") String fileName,
			@RequestParam("defaultvalue") String word, Model model) throws IOException {
		try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				XWPFDocument document = new XWPFDocument()) {
			XWPFParagraph paragraph = document.createParagraph();
			XWPFRun run = paragraph.createRun();
			run.setText("Hello, this is a generated Word document!");

			document.write(outputStream);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

			String basePath = "C:/STM_File/STM_File/";
			String filePath = basePath + fileName;

			String message = "Document Downloaded successfully!";
			headers.setContentDispositionFormData("attachment", filePath);

			model.addAttribute("message", message);
			
			return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
		} catch (IOException e) {
			model.addAttribute("error", "Please try again.");
			logger.error("Failed generate word file",e);
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/reset")
	public String resetClick(@RequestParam("ssoid") String ssoid,Model model)
			throws ClassNotFoundException, SQLException {
				System.out.println("start");
				SearchResultlist user=new SearchResultlist();
				user.setStmVersion("");
				user.setLinkDestination("");
				user.setTextShortEN("");
				user.setTextShortJP("");
				user.setPdfFile("");
				user.setWordFile("");
				user.setDraftingDate("");
				user.setOldSTMNumber("");
				user.setRemarks1("");
				user.setNote2("");
				user.setNote3("");
				
				model.addAttribute("ssoid", ssoid);
				model.addAttribute("entValue", user);
				return "SearchPage";
		
	}
}