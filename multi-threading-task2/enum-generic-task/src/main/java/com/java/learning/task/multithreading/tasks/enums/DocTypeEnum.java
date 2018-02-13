package com.java.learning.task.multithreading.tasks.enums;

public enum DocTypeEnum implements SuperEnum<String> {
	ADHAAR("adhaar"),
	PAN("pan"),
	BANK_STATEMENT("bank_statement");

	private String doc;

	private DocTypeEnum(String doc){
		this.doc = doc;
	}

	public String getValue(){
		return doc;
	}

}