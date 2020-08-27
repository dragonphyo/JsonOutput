package com.example.search.demo.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.search.demo.application.SearchManagementAPI;

@RestController
@RequestMapping("/api")
@Validated
public class SearchController {
	
	@Autowired
	private SearchManagementAPI api;
	
	@GetMapping("search-filters")
	public String getSearchCondition(@RequestParam("functionId") String functionId) {
		return api.getSearchFilters(functionId);
				
	}

}
