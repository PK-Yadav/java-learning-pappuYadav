package com.java.learning.task.multithreading.tasks.wordcount.docreader.readimpl;

import com.java.learning.task.multithreading.tasks.wordcount.docreader.readerwritterintf.IDocWritter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DocWritter implements IDocWritter{

	public void writeListOfLinesToFile(List<String> lines, String location) throws IOException{
		Files.write(Paths.get(location), lines.stream().collect(Collectors.toList()));
	}

	public void writeLineToFile(String line, String location) throws IOException{
		Files.write(Paths.get(location), line.getBytes());
	}
}