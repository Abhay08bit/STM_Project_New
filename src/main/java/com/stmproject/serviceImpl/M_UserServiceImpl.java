package com.stmproject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stmproject.model.M_User;
import com.stmproject.repository.M_UserRepository;
@Service

public abstract class M_UserServiceImpl implements M_UserRepository{
	
	 @Autowired
	    private M_UserRepository userRepository;

	    @Override
	    public M_User findBySsoid(String ssoid) {
	        return userRepository.findBySsoid(ssoid);
	    }

}
