package com.example.search.demo.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ErrorResponseDto {
	
	@JsonProperty("Condition")
	private String condition;
	@JsonProperty("Error Message")
	private String errorMessage;
	@JsonProperty("Status")
	private String status;
	@JsonProperty("Description")
	private String description;


}
