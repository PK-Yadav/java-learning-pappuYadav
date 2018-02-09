package com.java.learning.task.multithreading.tasks.docreader.readimpl;

import com.java.learning.task.multithreading.tasks.docreader.readerwritterintf.IDocReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * class to read a file from disk .
 */
public class DocReader implements IDocReader {

	/**
	 * will read a file line by line and return as list of string
	 * @param fileName
	 * @return
	 */
	public List<String> readFile(String fileName) {
		try {
			return Files.readAllLines(Paths.get(fileName));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return null;
	}
}