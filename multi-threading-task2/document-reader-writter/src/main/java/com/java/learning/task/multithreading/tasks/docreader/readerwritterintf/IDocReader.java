package com.java.learning.task.multithreading.tasks.docreader.readerwritterintf;

import java.util.List;

public interface IDocReader{

	List<String> readFile(String fileName);
}