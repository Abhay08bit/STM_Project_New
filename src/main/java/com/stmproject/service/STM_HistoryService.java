package com.stmproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stmproject.model.STM_Histo;
import com.stmproject.repository.STM_HistoryRepository;

@Service
public class STM_HistoryService {

@Autowired 
private STM_HistoryRepository stmHistoryRepository;

 public STM_Histo saveSTMHistory(STM_Histo stmHistory) {
     // Add any additional logic if needed
     return stmHistoryRepository.save(stmHistory);
 }
}

