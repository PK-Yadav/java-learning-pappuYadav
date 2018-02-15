package com.java.learning.task.multithreading.tasks.wordcount.autosuggest.pojo;

import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * Pojo class which will contain unique words
 *
 * @author pappuy
 */
public class AutoSuggestBuffer {
	private HashSet<String> buffer;

	public AutoSuggestBuffer(HashSet<String> buffer) {
		this.buffer = buffer;
	}

	public HashSet<String> getBuffer() {
		return buffer;
	}

	public void setBuffer(HashSet<String> buffer) {
		this.buffer = buffer;
	}

	/**
	 * This is will seach for key, and will return words which comes under search criteria
	 *
	 * @param keyRegex
	 * @return
	 */
	public HashSet<String> seachKeys(String keyRegex) {
		HashSet<String> matchedWords = new HashSet<>();
		matchedWords.addAll(getBuffer().stream().filter(word -> word.matches(keyRegex)).collect(Collectors.toSet()));
		return matchedWords;
	}
}