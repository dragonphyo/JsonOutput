package com.example.search.demo.business.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SearchFilterConditionModel {
	@JsonProperty("Search Filter Condition Id")
	private String SearchFilterConditionId;
	@JsonProperty("Filter Condition")
	private String FilterCondition;

}
