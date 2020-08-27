package com.example.search.demo.business.model;

public enum Message {
	CONDITION("Need to Set Query Parameter!!"), STATUS("HTTP Status 400"),
	MESSAGE("必須パラメータ [{0}] が存在しません / Required parameter {0} is not present");

	private String message;

	Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
