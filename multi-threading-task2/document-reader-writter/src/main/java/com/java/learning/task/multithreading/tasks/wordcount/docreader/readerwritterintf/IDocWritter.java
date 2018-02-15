package com.java.learning.task.multithreading.tasks.wordcount.docreader.readerwritterintf;

import java.io.IOException;
import java.util.List;


public interface IDocWritter{
	void writeListOfLinesToFile(List<String> lines , String location) throws IOException;
	void writeLineToFile(String line, String location) throws IOException;
}