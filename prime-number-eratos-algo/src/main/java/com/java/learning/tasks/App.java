package com.java.learning.tasks;

import com.java.learning.tasks.prime.Prime;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Prime number from 1 -30");
        Prime prime = new Prime();
        prime.printAllPrimeNumberUpToRange(12);
    }
}
