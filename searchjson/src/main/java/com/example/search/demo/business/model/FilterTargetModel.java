package com.example.search.demo.business.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FilterTargetModel {

	@JsonProperty("Filter Target Field Name")
	private String filterTargetFieldId;
	@JsonProperty("Target Name")
	private String targetName;
	@JsonProperty("Search Filter Condition")
	List<SearchFilterConditionModel> searchFilterConditionModels;

}
