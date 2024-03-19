package com.stmproject.serviceImpl;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stmproject.model.STM;
import com.stmproject.repository.STM_RegistrationRepository;
import com.stmproject.service.DeleteService;

@Service
public class DeleteServiceImpl implements DeleteService {
	@Autowired
	 private STM_RegistrationRepository stmRepository;

	@Override
	 public STM getStmByStmNo(String stmNo) {
	        return stmRepository.findById(stmNo).orElse(null);
	    }

	@Override    
	public boolean isDeleteStm(String stmNo) {
	        STM stm = stmRepository.findById(stmNo).orElse(null);
	        if (stm != null) {
	            stm.setIsDeleted(true);
	            stm.setLastUpdated(new Date());
	            stmRepository.save(stm);
	            return true;
	        }
	        return false;
 }
}
