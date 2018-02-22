package com.java.learning.task.multithreading.tasks.wordcount;

import com.java.learning.task.multithreading.tasks.wordcount.docreader.readimpl.DocReader;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

/**
 * WordCounter class responsible to store word with their count and calling fork-join pool to read all the files on the basis of
 * threshold value.
 *
 * @author pappuy
 */
public class WordCounter {
	private ConcurrentHashMap<String,Integer> wordCount = null;
	private String directory;

	public WordCounter(){
		wordCount = new ConcurrentHashMap<>(100);
	}

	public WordCounter(String directory){
		this();
		this.directory = directory;
	}

	public ConcurrentHashMap<String, Integer> getWordCount() {
		return wordCount;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public void setWordCount(ConcurrentHashMap<String, Integer> wordCount) {
		this.wordCount = wordCount;

	}

	public Integer getCounterByWord(String word){
		if(wordCount.containsKey(word)){
			return wordCount.get(word);
		}
		return 0;
	}

	public void addWords(List<String> lines){
		for(String key : lines) {
			if(wordCount.containsKey(key)){
				wordCount.put(key, getWordCount().get(key)+1);
			}else{
				wordCount.put(key, 1);
			}
		}
	}

	public void run(){
		List<Path> filePaths = new DocReader().readDirectory(getDirectory());
		ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
		WordCounterService wordCounterService = new WordCounterService(this, filePaths);
		forkJoinPool.execute(wordCounterService);
		wordCounterService.join();

		printWordsWithCount();
	}

	private void printWordsWithCount(){
		getWordCount().entrySet().stream().forEach(elem-> System.out.println(elem.getKey() + " : " + elem.getValue()));
	}

}