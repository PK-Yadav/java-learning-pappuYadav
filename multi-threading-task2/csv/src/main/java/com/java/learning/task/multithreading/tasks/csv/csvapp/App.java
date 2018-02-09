package com.java.learning.task.multithreading.tasks.csv.csvapp;

import com.java.learning.task.multithreading.tasks.csv.reader.CsvReader;

/**
 * This is main class for CsvFileSpliter app, this main thread will create a CsvReader thread to read file from directory,
 * and will split it into small small chunk.
 *
 */
public class App 
{
    private static final int NUMBER_OF_LINE_FOR_NEW_FILE= 3000;
    public static void main( String[] args )
    {
        new Thread(new CsvReader("/Users/pappuy/fileSpliter/input/Multithreading_Task1_Books.csv",NUMBER_OF_LINE_FOR_NEW_FILE)).start();
    }
}
