package com.java.learning.tasks.annotationvalidator;

import com.java.learning.tasks.annotation.FieldValidator;
import com.java.learning.tasks.annotation.NotNull;
import com.java.learning.tasks.common.ValidatorEnum;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomAnnotationValidator {
	private static final Logger logger = Logger.getLogger(CustomAnnotationValidator.class.getName());

	public static Map<String, String> annotationValidator(Object obj) throws RuntimeException {
		Map<String, String> response = new HashMap<>();
		Class aClass = obj.getClass();
		Field fields[] = aClass.getDeclaredFields();
		for (Field field : fields) {
			Annotation annotations[] = field.getDeclaredAnnotations();
			for (Annotation annotation : annotations) {
				String res = null;
				if (annotation instanceof NotNull) {
					res = validateNotNullField(field, obj);
				} else if (annotation instanceof FieldValidator) {
					res = validateFieldValidation(field, annotation, obj);
				}
				if (res != null) {
					response.put(field.getName(), res);
				}
			}
		}
		return response;
	}

	private static String validateNotNullField(Field field, Object obj) throws RuntimeException {
		try {
			field.setAccessible(true);
			Object value = field.get(obj);
			if (null == value) {
				return "Field : "+ field.getName() +" value can't be Null";
			}
		} catch (IllegalAccessException ex) {
			logger.log(Level.SEVERE, ex.getMessage());
		}
		return null;
	}

	private static String validateFieldValidation(Field field, Annotation annotation, Object obj) {
		//logger.log(Level.INFO, "validateFieldValidation method : " + field);
		try {
			field.setAccessible(true);
			String value = (String) field.get(obj);
			FieldValidator validator = (FieldValidator) annotation;
			ValidatorEnum type = validator.type();
			if (null != value && !value.matches(type.getValidatorRegex())) {
				return type.getValidationResponse();
			}
		} catch (IllegalAccessException ex) {
			logger.log(Level.SEVERE, ex.getMessage());
		}
		return null;
	}

}