package com.java.learning.task.multithreading.tasks.wordcount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * Service file which extends RecursiveAction class to bread reading files and store word count to Map.
 *
 * @author pappuy
 */
public class WordCounterService extends RecursiveAction{

	private WordCounter wordCounter;
	private List<Path>  filesPath;
	private final static int THREASHOLD = 1;

	public WordCounterService(WordCounter wordCounter, List<Path> filesPath) {
		this.wordCounter = wordCounter;
		this.filesPath = filesPath;
	}

	public void compute() {
		try {
			if (THREASHOLD >= filesPath.size()) {
				computeDiretcly();
			} else {
				ForkJoinTask.invokeAll(createSubTask());
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private List<WordCounterService> createSubTask(){
		List<WordCounterService> wordCounterServices = new ArrayList<>();
		wordCounterServices.add(new WordCounterService(wordCounter,filesPath.subList(0, THREASHOLD)));
		wordCounterServices.add(new WordCounterService(wordCounter,filesPath.subList(THREASHOLD, filesPath.size())));
		return wordCounterServices;
	}

	public void computeDiretcly() throws IOException{
		System.out.println("Thread " + Thread.currentThread().getName() +" started computing");
		for(Path filePath : filesPath){
			wordCounter.addWords(Files.readAllLines(filePath));
		}
		System.out.println("Thread " + Thread.currentThread().getName() +" finished computing");
	}
}