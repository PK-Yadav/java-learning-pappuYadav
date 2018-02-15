package com.java.learning.task.multithreading.tasks.wordcount.docparser.parserintf;

import java.util.List;

public interface IDocParser{
	List<String> parse(String fileName);
	List<String> parseLines(List<String> lines);
}