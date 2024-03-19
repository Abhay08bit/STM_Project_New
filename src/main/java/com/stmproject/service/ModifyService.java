package com.stmproject.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.stmproject.model.STM;

public interface ModifyService {
	STM getSTMByStmNoQuery(String stmNo);

    void modifySTM(STM modifySTM, MultipartFile pdfFile, MultipartFile wordFile,String ssoid) throws IOException;

    //String saveFile(MultipartFile file, String extension) throws IOException;
    String saveFile(MultipartFile file, String stmNo, String revisionNo, String extension) throws IOException;
}
    
