package com.java.learning.task.multithreading.tasks.wordcount.autosuggest.app;

import com.java.learning.task.multithreading.tasks.wordcount.autosuggest.service.AutoSuggestService;
import com.java.learning.task.multithreading.tasks.wordcount.autosuggest.util.SearchTypeEnum;

import java.util.Scanner;

/**
 * Main class, start of this application.
 *
 * @author pappuy
 */
public class App {
	public static void main(String[] args) {
		try {
			Scanner kb = new Scanner(System.in);
			System.out.println("Hello Welcome to auto suggest search!");
			System.out.print("Please type character for which auto suggest required ..... ");
			String key = kb.next();
			System.out.println("Please provide type of search. Like PRE/POS/FUZ");
			String searchType = kb.next();
			AutoSuggestService autoSuggestSearch = new AutoSuggestService(key, "/Users/pappuy/wikiurldata/input/autosuggest.txt", SearchTypeEnum
					.getSearchTypeEnumByValue(searchType));
			autoSuggestSearch.readFileAndPerformAutoSuggest();
			kb.close();
		}catch (Exception ex){
			ex.printStackTrace();
		}

	}
}
