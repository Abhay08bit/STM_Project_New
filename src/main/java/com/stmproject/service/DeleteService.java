package com.stmproject.service;

import com.stmproject.model.STM;

public interface DeleteService {
    STM getStmByStmNo(String stmNo);
    boolean isDeleteStm(String stmNo);		    
}