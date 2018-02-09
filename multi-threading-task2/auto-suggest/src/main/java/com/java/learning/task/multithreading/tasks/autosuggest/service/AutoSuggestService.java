package com.java.learning.task.multithreading.tasks.autosuggest.service;

import com.java.learning.task.multithreading.tasks.autosuggest.pojo.AutoSuggestBuffer;
import com.java.learning.task.multithreading.tasks.autosuggest.util.RegexGenerator;
import com.java.learning.task.multithreading.tasks.autosuggest.util.SearchTypeEnum;
import com.java.learning.task.multithreading.tasks.docparser.factory.ParserFactory;
import com.java.learning.task.multithreading.tasks.docparser.parserenum.ParserPattern;
import com.java.learning.task.multithreading.tasks.docparser.parserintf.IDocParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;

/**
 * AutoSuggestService class, mainly contains code to perform reading of file and storing it into buffer.
 * will perfom search on buffer
 *
 * @author pappuy
 */
public class AutoSuggestService{
	private String         searchKey  = null;
	private String         fileName   = null;
	private SearchTypeEnum searchType = null;

	public AutoSuggestService(String searchKey, String fileName, SearchTypeEnum searchType) {
		this.searchKey = searchKey;
		this.fileName = fileName;
		this.searchType = searchType;
	}

	public void readFileAndPerformAutoSuggest() throws IOException {
		IDocParser docParser = ParserFactory.getParser(ParserPattern.SPACE);
		AutoSuggestBuffer buffer = new AutoSuggestBuffer(new HashSet<>(docParser.parse(getFileName())));
		HashSet<String> suggestedWords = buffer.seachKeys(RegexGenerator.getRegexForkeyBySearchType(getSearchKey(), getSearchType()));
		display(suggestedWords);
	}

	private void display(HashSet<String> suggestedWords) {
		suggestedWords.stream().forEach(elem -> System.out.println(elem));
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public SearchTypeEnum getSearchType() {
		return searchType;
	}

	public void setSearchType(SearchTypeEnum searchType) {
		this.searchType = searchType;
	}
}