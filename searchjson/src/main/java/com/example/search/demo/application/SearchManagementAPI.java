package com.example.search.demo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.search.demo.business.SearchBusiness;

@Service
public class SearchManagementAPI {
	
	@Autowired
	private SearchBusiness business;
	

	public String getSearchFilters(String functionId) {
		// TODO Auto-generated method stub
		return business.getSearchFilters(functionId);
	}
	
	

}
