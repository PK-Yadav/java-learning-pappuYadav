package com.java.learning.task.multithreading.tasks.wordcount.autosuggest.util;

/**
 * This class is for regex generation as per search type
 *
 * @author pappuy
 */
public final class RegexGenerator {

	/**
	 * will return a regexString as per search type
	 * @param key
	 * @param seachTypeEnum
	 * @return
	 */
	public static String getRegexForkeyBySearchType(String key, SearchTypeEnum seachTypeEnum) {
		String regexString = null;
		switch (seachTypeEnum) {
		case POSTFIX:
			regexString = ".*("+key+")$";
			break;
		case PREFIX:
			regexString = "^("+key+").*";
			break;
		case FUZZY:
			regexString = ".*("+key+").*";
			break;
		}
		return regexString;
	}
}