package com.java.learning.tasks.lru.lruservice;

import com.java.learning.tasks.lru.node.LinkList;

import java.util.Scanner;

/**
 * This file is created like a service, which will handle implementation if LRU concept
 */
public class LRUService {
	LinkList list =  null;

	public LRUService(){
		list =  new LinkList();
	}

	/**
	 * Method is responsible to handle LRU cache logic, here i have putted 3 nodes as cache size, one can change as per his/her requirement
	 *
	 * @param nodeData
	 */
	public void storeDataAsLruCache(String nodeData) {
		if (list.getSize() == 3) {
			if (list.contains(nodeData)) {
				list.deleteNode(nodeData);
				list.insertAtBegining(nodeData);
			} else {
				list.deleteAtLast();
				list.insertAtBegining(nodeData);
			}
		} else {
			list.insertAtBegining(nodeData);
		}
	}

	public void displayLRUCache(){
		list.display();
	}
}