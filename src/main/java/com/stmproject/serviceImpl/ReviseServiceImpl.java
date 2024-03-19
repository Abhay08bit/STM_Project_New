package com.stmproject.serviceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stmproject.model.STM;
import com.stmproject.model.STM_Histo;
import com.stmproject.repository.ReviseRepository;
import com.stmproject.repository.STM_HistoryRepository;
import com.stmproject.service.ReviseService;

@Service
public class ReviseServiceImpl implements ReviseService {
	@Autowired
    private ReviseRepository reviceRepository;
	
	@Autowired
    private STM_HistoryRepository historyRepository;
	
	@Override
    public STM getSTMById(String id) {
        Optional<STM> stmOptional = reviceRepository.findByStmNo(id);
        return stmOptional.orElse(null);
    }
               
    private static final String UPLOAD_DIR = "/STM_File";
    
    @Override
    @Transactional
    public void updateSTM(STM updatedSTM,MultipartFile pdfFile, MultipartFile wordFile,String ssoid) throws IOException {
        Optional<STM> optionalSTM = reviceRepository.findByStmNo(updatedSTM.getStmNo());               
        if (optionalSTM.isPresent()){           
             STM existingSTM = optionalSTM.get();
                                      
             int latestRevisionNo = Integer.parseInt(updatedSTM.getStmVersion());
//             System.out.println("Latest Revision No: " + latestRevisionNo);
//
//             int newRevisionNo = latestRevisionNo + 1;
//             System.out.println("New Revision No: " + newRevisionNo);
//
//             //Convert the new revision number back to a String
             String newRevisionString = String.valueOf(latestRevisionNo);
             System.out.println("New Revision No as String: " + newRevisionString);
             
             createHistoryRecord(existingSTM);             
             String pdfFileName = (pdfFile != null && !pdfFile.isEmpty()) ? saveFile(pdfFile, existingSTM.getStmNo(), newRevisionString, "pdf") : existingSTM.getPdfFile();
             String wordFileName = (wordFile != null && !wordFile.isEmpty()) ? saveFile(wordFile, existingSTM.getStmNo(), newRevisionString, "doc") : existingSTM.getWordFile();

            //Update the existingSTM with values from updatedSTM
            existingSTM.setLinkDestination(updatedSTM.getLinkDestination());
            existingSTM.setTextShortEN(updatedSTM.getTextShortEN());
            existingSTM.setTextShortJP(updatedSTM.getTextShortJP());
            existingSTM.setPdfFile(pdfFileName);
            existingSTM.setWordFile(wordFileName);
            existingSTM.setDraftingDate(updatedSTM.getDraftingDate());
            existingSTM.setFinalDrafterName(updatedSTM.getFinalDrafterName());
            existingSTM.setOldSTMNumber(updatedSTM.getOldSTMNumber());
            existingSTM.setRemarks1(updatedSTM.getRemarks1());
            existingSTM.setNote2(updatedSTM.getNote2());
            existingSTM.setCreatorSSOID(ssoid);
            existingSTM.setNote3(updatedSTM.getNote3());
            existingSTM.setStmVersion("0"+newRevisionString);
            existingSTM.setLastUpdated(new Date());
            // Save the updated entity            
            reviceRepository.save(existingSTM);
            
        } else {
            // Handle the case where STM with stmNo is not found
        }
                     
    }
    
    
   private void createHistoryRecord(STM existingSTM) {
    	System.out.println(existingSTM);
    	STM_Histo stmHistory = new STM_Histo();
        stmHistory.setStmNo(existingSTM.getStmNo());
        stmHistory.setStmVersion(existingSTM.getStmVersion());
        stmHistory.setLinkDestination(existingSTM.getLinkDestination());
        stmHistory.setTextShortEN(existingSTM.getTextShortEN());
        stmHistory.setTextShortJP(existingSTM.getTextShortJP());
        stmHistory.setPdfFile(existingSTM.getPdfFile());
        stmHistory.setWordFile(existingSTM.getWordFile());
        stmHistory.setLastUpdated(existingSTM.getLastUpdated());
        stmHistory.setDraftingDate(existingSTM.getDraftingDate());
        stmHistory.setFinalDrafterName(existingSTM.getFinalDrafterName());
        stmHistory.setOldSTMNumber(existingSTM.getOldSTMNumber());
        stmHistory.setRemarks1(existingSTM.getRemarks1());
        stmHistory.setNote2(existingSTM.getNote2());
        stmHistory.setNote3(existingSTM.getNote3());
        stmHistory.setCreatorSSOID(existingSTM.getCreatorSSOID());
        stmHistory.setCreatedDate(existingSTM.getCreatedDate());
        stmHistory.setLastUpdated(existingSTM.getLastUpdated());
        stmHistory.setDeleted(existingSTM.getIsDeleted());
        historyRepository.save(stmHistory);		
	}
   
   
   @Override
   public String saveFile(MultipartFile file, String stmNo, String revisionNo, String extension) throws IOException {
       if (file != null && !file.isEmpty()) {
           //String originalFileName = file.getOriginalFilename();

           // Generate a new unique file name using STMNo, RevisionNo
           String newFileName = "STM" + stmNo +"0"+revisionNo+ "." + extension;

           Path uploadPath = Paths.get("/STM_File", UPLOAD_DIR);
           Path filePath = uploadPath.resolve(newFileName);

           // Create directories if they don't exist
           Files.createDirectories(uploadPath);
           // Save the file to the specified directory with the new file name
           Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

           // Return the new file name to be stored in your model
           return newFileName;
       }
       return null;
   }
 
}

