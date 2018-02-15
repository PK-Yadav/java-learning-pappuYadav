package com.java.learning.task.multithreading.tasks.wordcount.docreader.readimpl;

import com.java.learning.task.multithreading.tasks.wordcount.docreader.readerwritterintf.IDocReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * class to read a file from disk .
 */
public class DocReader implements IDocReader {

	/**
	 * will read a file line by line and return as list of string
	 *
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

	public List<String> readFile(Path path) {
		try {
			return Files.readAllLines(path);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return null;
	}

	public List<Path> readDirectory(String directory) {
		List<Path> filesPath = new ArrayList<>();
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(directory))) {
			for (Path path : stream) {
				filesPath.add(path);
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
		return filesPath;
	}
}