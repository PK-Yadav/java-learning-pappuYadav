package com.java.learning.task.multithreading.tasks;

import com.java.learning.task.multithreading.tasks.enuminstance.EnumInstanceGenerator;
import com.java.learning.task.multithreading.tasks.enums.DocTypeEnum;
import com.java.learning.task.multithreading.tasks.enums.WeekEnum;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String pan = "pan";
        int day = 7;
        DocTypeEnum doc = EnumInstanceGenerator.getEnumInstance(DocTypeEnum.class,pan);
        WeekEnum weekDay = EnumInstanceGenerator.getEnumInstance(WeekEnum.class, day);
        System.out.println("Document is of type " + doc);
        System.out.println("Week day is "+ weekDay);

    }
}
