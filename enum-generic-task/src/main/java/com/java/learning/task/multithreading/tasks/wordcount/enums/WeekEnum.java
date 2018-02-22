package com.java.learning.task.multithreading.tasks.wordcount.enums;
import com.java.learning.task.multithreading.tasks.wordcount.enumintf.SuperEnum;

public enum WeekEnum implements SuperEnum<Integer>{
	SUNDAY(1),
	MONDAY(2),
	TUESDAY(3),
	WEDNESDAY(4),
	THURSDAY(5),
	FRIDAY(6),
	SATUARDAY(7);

	private int day;

	private WeekEnum(int day){
		this.day = day;
	}

	public Integer getValue(){
		return day;
	}
}