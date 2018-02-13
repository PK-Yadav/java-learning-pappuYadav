package com.java.learning.task.multithreading.tasks.enuminstance;

import com.java.learning.task.multithreading.tasks.enums.SuperEnum;

public class EnumInstanceGenerator{

	public static <V, R extends SuperEnum> R getEnumInstance(Class<R> r, V v) {

		SuperEnum[] contansts = r.getEnumConstants();
		for (SuperEnum enumConst : contansts){
			if (enumConst.getValue().equals(v)) {
				return (R) enumConst;
			}
		}

		return null;
	}

}