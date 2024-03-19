package com.stmproject.serviceImpl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stmproject.model.STM;

import com.stmproject.repository.STM_RegistrationRepository;
import com.stmproject.service.STM_RegistrationService;


@Service
public class STM_RegistrationServiceImpl implements STM_RegistrationService {

	
	@Autowired
    private STM_RegistrationRepository stmRepository;
    
    
    @Override
    public STM isSTMNumberExists(String stmNumber) {
        return stmRepository.existsByStmNo(stmNumber);
    }

	@Override
	public void saveSTM(STM stm) {
		 stmRepository.save(stm);
	}	
}
