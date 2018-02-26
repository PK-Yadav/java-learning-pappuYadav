package com.java.learning.tasks.common;

public enum ValidatorEnum{
	IDENTIFIER("^[a-zA-Z_][a-zA-Z0-9]{8,25}", " Identifier should start with alphabet or _ and size could be 8 to 25."),
	EMAIL("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9]+.[a-zA-Z]{2,4}", "Email should contain one @ and at least one . after @."),
	MOBILE("^[0-9]{10}", "Mobile number should be numeric of size 10."),
	AADHAR("\\d{12}"," Aadhar number should be numeric of size 12."),
	PAN("^[A-Z]{5}[0-9]{4}[A-Z]{1}"," Pan number must start with 5 alphabetic charcter then 4 numeric value and ending character must be alphabet of size 10.");


	String validatorRegex;
	String validationResponse;

	ValidatorEnum(String validatorRegex, String validationResponse){
		this.validatorRegex = validatorRegex;
		this.validationResponse = validationResponse;
	}

	public String getValidatorRegex(){
		return this.validatorRegex;
	}

	public String getValidationResponse(){
		return this.validationResponse;
	}

}