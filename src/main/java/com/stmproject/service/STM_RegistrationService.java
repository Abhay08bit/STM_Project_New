package com.stmproject.service;
import org.springframework.stereotype.Service;

import com.stmproject.model.STM;

@Service
public interface STM_RegistrationService {
	
	STM isSTMNumberExists(String stmNumber);
	
	void saveSTM(STM stm);
	


}
