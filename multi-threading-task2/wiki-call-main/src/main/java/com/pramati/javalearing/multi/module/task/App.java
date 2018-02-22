package com.pramati.javalearing.multi.module.task;

import com.java.learning.task.multithreading.tasks.wordcount.docparser.parserenum.ParserPattern;
import com.pramati.javalearing.multi.module.task.filereaderandparser.FileReaderAndParser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This is main method for this multi module maven project
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String inputFileName1 = "/Users/pappuy/fileSpliter/input/Multithreading_Task_2_java Keywords.txt";
        String inputFileName2 = "/Users/pappuy/fileSpliter/input/Multithreading_Task_2_fortune1000companies.txt";
        String urlPattern = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles=";
        ParserPattern parserPattern = ParserPattern.SPACETAB;
        ParserPattern commaParser = ParserPattern.COMMA;
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new FileReaderAndParser(inputFileName1, urlPattern,commaParser));
        service.execute(new FileReaderAndParser(inputFileName2, urlPattern,parserPattern));
        service.shutdown();
        while (!service.isTerminated()){

        }
    }
}
