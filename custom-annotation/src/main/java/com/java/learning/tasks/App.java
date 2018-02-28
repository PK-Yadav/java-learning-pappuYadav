package com.java.learning.tasks;

import com.java.learning.tasks.annotationvalidator.CustomAnnotationValidator;
import com.java.learning.tasks.documents.Aadhar;
import com.java.learning.tasks.documents.PanCard;

import java.util.Date;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Map<String, String> response = null;
		Aadhar aadhar = new Aadhar("firstName", null, null, "1234123", "9643606096", "email@com.co", new Date());
		//response = CustomAnnotationValidator.annotationValidator(aadhar);
		if (response != null &&  !response.isEmpty()) {
			showValidationError(response);
		}

		PanCard pan = new PanCard("firstNa", null, null, "1234123", "9643606096", "email@com.co", new Date());
		//response = CustomAnnotationValidator.annotationValidator(pan);
		if (response != null &&  !response.isEmpty()) {
			showValidationError(response);
		}

	}

	public static void showValidationError(Map<String, String> response) {
		for (Map.Entry<String, String> map : response.entrySet()) {
			System.out.println("Field " + map.getKey() + ", : " + map.getValue());
		}
	}

	public static void showDataConsistancyValidationError(Map<String, String> response) {
		for (Map.Entry<String, String> map : response.entrySet()) {
			System.out.println( map.getKey() + ", : " + map.getValue());
		}
	}
}
