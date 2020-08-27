package com.example.search.demo.presentation;

import java.text.MessageFormat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.search.demo.business.model.Message;
import com.example.search.demo.presentation.dto.ErrorResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class GolbalExceptionHandler {

	@ExceptionHandler(Exception.class)
	private ResponseEntity<String> handlerNotFound(Exception e) {
		if (e instanceof MissingServletRequestParameterException) {
			String errorMessage = e.getMessage().split("\'")[1];
			return getErrorMessage(HttpStatus.BAD_REQUEST, errorMessage, e);
		} else {
			return getErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Server Error", e);
		}
	}

	private ResponseEntity<String> getErrorMessage(HttpStatus status, String message, Exception e) {
		ObjectMapper mapper = new ObjectMapper();
		String errorMessage = null;
		ErrorResponseDto dto = new ErrorResponseDto();
		dto.setCondition(Message.CONDITION.getMessage());
		dto.setDescription(e.getMessage());
		dto.setErrorMessage(getErrorMesage(message));
		dto.setStatus(Message.STATUS.getMessage());
		try {
			errorMessage = mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		return new ResponseEntity<String>(errorMessage, status);

	}

	private String getErrorMesage(String message) {
		return MessageFormat.format(Message.MESSAGE.getMessage(), message);
	}
}
