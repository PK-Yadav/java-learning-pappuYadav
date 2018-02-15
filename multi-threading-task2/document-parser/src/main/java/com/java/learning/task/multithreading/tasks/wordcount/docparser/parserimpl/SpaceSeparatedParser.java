package com.java.learning.task.multithreading.tasks.wordcount.docparser.parserimpl;

import com.java.learning.task.multithreading.tasks.wordcount.docparser.parserintf.IDocParser;
import com.java.learning.task.multithreading.tasks.wordcount.docreader.readerwritterintf.IDocReader;
import com.java.learning.task.multithreading.tasks.wordcount.docreader.readimpl.DocReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpaceSeparatedParser implements IDocParser{

	public List<String> parse(String fileName) {
		IDocReader reader = new DocReader();
		List<String> fileLines = reader.readFile(fileName);
		List<String> parsedData = parseLines(fileLines);
		return parsedData;
	}

	/**
	 * This method will parse a list of string one by one by space-tab combination and return list of 2nd string as list.
	 *
	 * @param lines
	 * @return
	 */
	public List<String> parseLines(List<String> lines) {
		List<String> words = new ArrayList<>();
		for (String line : lines) {
			words.add(Stream.of(line.split(" ")).filter(elem -> Objects.nonNull(elem)).filter(elem -> !elem.isEmpty()).map(elem -> new String(elem))
					.collect(Collectors.toList()).get(1));
		}
		return words;
	}

}