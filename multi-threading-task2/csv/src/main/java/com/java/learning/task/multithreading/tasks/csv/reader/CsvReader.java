package com.java.learning.task.multithreading.tasks.csv.reader;

import com.java.learning.task.multithreading.tasks.csv.writter.CsvWritterFork;
import com.java.learning.task.multithreading.tasks.docreader.readimpl.DocReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * This is CvsReader file, which is responsible to read file from disk and write it to new files by split them
 *
 * @author pappuy
 */
public class CsvReader implements Runnable{

	private String inputFileName;
	private int lines;

	public CsvReader(String inputFileName, int lines){
		this.inputFileName = inputFileName;
		this.lines = lines;
	}
	public String getInputFileName() {
		return inputFileName;
	}

	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	public int getLines() {
		return lines;
	}

	public void setLines(int lines) {
		this.lines = lines;
	}

	public void run() {
		try {
			List<String> fileBufferLines = new DocReader().readFile(getInputFileName());
			ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
			CsvWritterFork csvSpliter = new CsvWritterFork(fileBufferLines, getLines());
			forkJoinPool.execute(csvSpliter);
			csvSpliter.join();
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

}