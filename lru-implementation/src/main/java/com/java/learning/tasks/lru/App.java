package com.java.learning.tasks.lru;

import com.java.learning.tasks.lru.node.LinkList;

import java.util.Scanner;

/**
 * Main class to test LRU implementation, currently i have selected cache of size 3.
 *
 * @author pappuy
 */
public class App {
	public static void main(String[] args) {
		LinkList list = new LinkList();
		Scanner kb = new Scanner(System.in);
		String check = null;
		while (!"quit".equals(check)) {
			System.out.print("Please enter a string for new Node : ");
			check = kb.nextLine();
			if (list.getSize() == 3) {
				if (list.contains(check)) {
					list.deleteNode(check);
					list.insertAtBegining(check);
					list.display();
				} else {
					list.deleteAtLast();
					list.insertAtBegining(check);
					list.display();
				}
			}else{
				list.insertAtBegining(check);
			}
		}
	}
}
