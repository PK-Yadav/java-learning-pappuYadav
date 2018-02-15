package com.java.learning.task.multithreading.tasks.wordcount.docreader.readerwritterintf;

import java.nio.file.Path;
import java.util.List;

public interface IDocReader{

	List<String> readFile(String fileName);

	List<String> readFile(Path path);

	List<Path> readDirectory(String diectory);
}