package com.stmproject.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.stmproject.model.SearchResultlist;

@Service
public interface S_UserService {

	public List<SearchResultlist> getAllValues();

	public List<SearchResultlist> getValuesBySetValue(SearchResultlist dao);
	
	public boolean isAdminLogin(String userId);
	
	public SearchResultlist setEmptyForNullValues(SearchResultlist dao);
	
	public SearchResultlist findBySTMNo(String stmNo);
}