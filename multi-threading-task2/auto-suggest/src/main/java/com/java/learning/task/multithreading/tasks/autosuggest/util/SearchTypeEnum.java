package com.java.learning.task.multithreading.tasks.autosuggest.util;

/**
 * Enum to represent Search type
 *
 * @author pappuy
 */
public enum SearchTypeEnum {
	PREFIX("PRE"), POSTFIX("POS"), FUZZY("FUZ");

	private String value;

	SearchTypeEnum(String value) {
		this.value = value;
	}

	public static SearchTypeEnum getSearchTypeEnumByValue(String value) {
		for (SearchTypeEnum typeEnum : SearchTypeEnum.values()) {
			if (value.equals(typeEnum.value)) {
				return typeEnum;
			}
		}
		return null;
	}
}