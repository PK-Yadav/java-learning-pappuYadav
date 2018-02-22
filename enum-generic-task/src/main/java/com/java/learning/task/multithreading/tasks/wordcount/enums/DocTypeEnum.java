package com.java.learning.task.multithreading.tasks.wordcount.enums;

import com.java.learning.task.multithreading.tasks.wordcount.enumintf.SuperEnum;

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