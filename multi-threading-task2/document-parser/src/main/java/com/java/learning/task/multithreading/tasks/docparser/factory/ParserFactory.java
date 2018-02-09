package com.java.learning.task.multithreading.tasks.docparser.factory;

import com.java.learning.task.multithreading.tasks.docparser.parserenum.ParserPattern;
import com.java.learning.task.multithreading.tasks.docparser.parserimpl.CommaSeparatedParser;
import com.java.learning.task.multithreading.tasks.docparser.parserimpl.SpaceAndTabParser;
import com.java.learning.task.multithreading.tasks.docparser.parserimpl.SpaceSeparatedParser;
import com.java.learning.task.multithreading.tasks.docparser.parserintf.IDocParser;

/**
 * this is a factory class for IDocParser interface, it will return an object of IDocParser implementation class's object,
 * on the basis of passed parser pattern.
 */
public class ParserFactory{

	/**
	 * object of IDocParser, implementation classes on the basis of passed pattern parse enum.
	 * @param parserPattern
	 * @return
	 */
	public static IDocParser getParser(ParserPattern parserPattern){
		switch (parserPattern){
		case COMMA: return new CommaSeparatedParser();
		case SPACETAB: return new SpaceAndTabParser();
		case SPACE: return new SpaceSeparatedParser();
		default: return null;
		}

	}
}