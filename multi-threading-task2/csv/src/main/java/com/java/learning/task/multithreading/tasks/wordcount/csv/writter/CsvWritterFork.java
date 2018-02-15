package com.java.learning.task.multithreading.tasks.wordcount.csv.writter;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;

public class CsvWritterFork extends RecursiveAction{

	private List<String> fileBufferLines;
	private int line;

	public CsvWritterFork(List<String> fileBufferLines, int line){
		this.line = line;
		this.fileBufferLines = fileBufferLines;
	}

	Map map = new HashMap<>();

	@Override protected void compute() {
		if (fileBufferLines.size() <= line) {
			computeDirectly();
		}else {
			ForkJoinTask.invokeAll(createSubTask());
		}
	}

	private List<CsvWritterFork> createSubTask() {
		List<CsvWritterFork> subTask = new ArrayList<>();
		List<String> left = fileBufferLines.subList(0, line);
		List<String> right = fileBufferLines.subList(line, fileBufferLines.size());
		subTask.add(new CsvWritterFork(left, line));
		subTask.add(new CsvWritterFork(right, line));
		return subTask;
	}

	private void computeDirectly() {
		try {
			System.out.println("Thread " + Thread.currentThread().getName() + " started computing");
			String outputFileName = "/Users/pappuy/fileSpliter/output/File_" + UUID.randomUUID().toString() + ".txt";
			Files.write(Paths.get(outputFileName), fileBufferLines.stream().collect(Collectors.toList()));
			System.out.println("Thread " + Thread.currentThread().getName() + " Finished computing");
		}catch (Exception ex){
			ex.printStackTrace();
		}

	}

}