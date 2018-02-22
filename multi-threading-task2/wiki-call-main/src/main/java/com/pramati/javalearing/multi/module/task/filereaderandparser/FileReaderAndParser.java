package com.pramati.javalearing.multi.module.task.filereaderandparser;

import com.java.learning.task.multithreading.tasks.wordcount.docparser.factory.ParserFactory;
import com.java.learning.task.multithreading.tasks.wordcount.docparser.parserenum.ParserPattern;
import com.java.learning.task.multithreading.tasks.wordcount.docparser.parserintf.IDocParser;
import com.java.learning.task.multithreading.tasks.wordcount.docreader.readimpl.DocReader;
import com.java.learning.task.multithreading.tasks.wordcount.wikicall.WikiReadWriteCall;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * This class is mainly used to read inputfile data from disk and parse it into passed parserPattern. And will use fork and Join
 * to process parsed list, to read url data.
 *
 * @author pappuy
 */
public class FileReaderAndParser implements Runnable{
	private String inputFile;
	private String urlPattern;
	private ParserPattern parserPattern;

	public FileReaderAndParser(String inputFile, String urlPattern, ParserPattern parserPattern){
		this.inputFile = inputFile;
		this.urlPattern = urlPattern;
		this.parserPattern = parserPattern;
	}

	public void run(){
		List<String> listKeywords = null;
		IDocParser parser = ParserFactory.getParserInstance(getParserPattern());
		if(null != parser) {
			listKeywords = parser.parse(getInputFile());
		}else{
			listKeywords = new DocReader().readFile(getInputFile());
		}
		ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
		WikiReadWriteCall wikiReadWriteCall = new WikiReadWriteCall(listKeywords,getUrlPattern());
		forkJoinPool.execute(wikiReadWriteCall);
		wikiReadWriteCall.join();

	}


	public ParserPattern getParserPattern() {
		return parserPattern;
	}

	public void setParserPattern(ParserPattern parserPattern) {
		this.parserPattern = parserPattern;
	}

	public String getInputFile() {
		return inputFile;
	}

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	public String getUrlPattern() {
		return urlPattern;
	}

	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}

}