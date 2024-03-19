package com.stmproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stmproject.model.M_User;
import com.stmproject.repository.M_UserRepository;

@Service
public class M_UserService {
	@Autowired
    private M_UserRepository userRepository;

    public M_User findBySsoid(String ssoid) {
        return userRepository.findBySsoid(ssoid);
    }

}
