package com.java.learning.tasks.lru;

import com.java.learning.tasks.lru.lruservice.LRUService;
import com.java.learning.tasks.lru.node.LinkList;

import java.util.Scanner;

/**
 * Main class to test LRU implementation, currently i have selected cache of size 3.
 *
 * @author pappuy
 */
public class App {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		LRUService service = new LRUService();
		String check = null;
		while (true) {
			System.out.println("Enter q to quit this LRU");
			System.out.println("Enter d to display LRU cache");
			System.out.println("Other than y & d will be added to LRU cache \n");
			System.out.print("Enter your option : ");
			check = kb.nextLine();
			if("d".equals(check)){
				service.displayLRUCache();
			}else if("q".equals(check)){
				System.out.println("Recently used data in LRU cache \n");
				service.displayLRUCache();
				break;
			}else{
				service.storeDataAsLruCache(check);
			}
		}

	}
}
