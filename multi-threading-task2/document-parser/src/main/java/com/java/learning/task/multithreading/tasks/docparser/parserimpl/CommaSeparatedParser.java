package com.java.learning.task.multithreading.tasks.docparser.parserimpl;

import com.java.learning.task.multithreading.tasks.docparser.parserintf.IDocParser;
import com.java.learning.task.multithreading.tasks.docreader.readerwritterintf.IDocReader;
import com.java.learning.task.multithreading.tasks.docreader.readimpl.DocReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This file has implemented IDocParser, this class has overridden parse method, which will parse a file lines
 * on the basis of comma.
 *
 * @author pappuy
 */
public class CommaSeparatedParser implements IDocParser {

	/**
	 * this method will call readFile of DocReader, and then will split all the line on the basis of comma ','
	 *
	 * @param fileName
	 * @return list of words, after splitting each line by ,
	 */
	public List<String> parse(String fileName) {
		IDocReader reader = new DocReader();
		List<String> fileLines = reader.readFile(fileName);
		List<String> parsedData = parseLines(fileLines);
		return parsedData;
	}

	/**
	 * This method will parse a list of string  one by one into list of string on the basis of comma separated string
	 * @param lines
	 * @return
	 */
	public List<String> parseLines(List<String> lines) {
		List<String> words = new ArrayList<>();
		for (String line : lines) {
			words.addAll(Stream.of(line.split(",")).filter(elem -> Objects.nonNull(elem)).filter(elem -> !elem.isEmpty()).map(elem -> new String(elem))
					.collect(Collectors.toList()));
		}
		return words;
	}

}