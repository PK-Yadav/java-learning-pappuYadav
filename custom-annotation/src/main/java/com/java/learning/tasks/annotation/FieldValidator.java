package com.java.learning.tasks.annotation;

import com.java.learning.tasks.common.ValidatorEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * FieldValidator annotation, to check name validation on a field
 *
 * @author pappuy
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldValidator {
	ValidatorEnum type();
}