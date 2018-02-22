package com.java.learning.task.multithreading.tasks.wordcount;

/**
 * App class starting point for word count task.
 *
 * @author pappuy
 */
public class App 
{
    /**
     * Main method, just change the directory which has multiple files, and assuming all the files contain one word in a line.
     * @param args
     */
    public static void main( String[] args )
    {
        new WordCounter("/Users/pappuy/fileSpliter/wordcount").run();
    }
}
