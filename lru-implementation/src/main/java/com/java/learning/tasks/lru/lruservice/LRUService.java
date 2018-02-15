package com.java.learning.tasks.lru.lruservice;

import com.java.learning.tasks.lru.node.LinkList;

import java.util.Scanner;

public class LRUService {
	LinkList list =  null;

	public LRUService(){
		list =  new LinkList();
	}

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