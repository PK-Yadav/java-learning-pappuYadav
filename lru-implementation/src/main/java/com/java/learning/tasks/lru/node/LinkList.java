package com.java.learning.tasks.lru.node;

/**
 * Link List class and its operation.
 *
 * @author pappuy
 */
public class LinkList {

	private ListNode start;
	private int      size;

	public ListNode getStart() {
		return start;
	}

	public void setStart(ListNode start) {
		this.start = start;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * this will insert new node at begining of existing list
	 * @param page
	 */
	public void insertAtBegining(String page) {
		size++;
		if (null == start) {
			start = new ListNode(page, null);
			return;
		}
		ListNode node = new ListNode(page, null);
		node.setNext(start);
		start = node;
	}

	/**
	 * To display LRU cache data
	 */
	public void display() {
		ListNode temp = start;
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}

	/**
	 * This method will delete a node from last.
	 */
	public void deleteAtLast() {
		ListNode headF = start;
		if (start.getNext() == null) {
			start = null;
			size--;
			return;
		}
		while (start.getNext().getNext() != null) {
			start = start.getNext();
		}
		size--;
		start.setNext(null);
		start = headF;
	}

	/**
	 * this will return true/false if data already exist in list..
	 * @param data
	 * @return
	 */
	public boolean contains(String data) {
		ListNode tempNode = start;
		while (tempNode != null) {
			if (tempNode.getData().equals(data)) {
				return true;
			}
			tempNode = tempNode.getNext();
		}
		return false;
	}

	/**
	 * This method is responsible to delete a node from list, on the basis of value.
	 * @param data
	 */
	public void deleteNode(String data) {
		ListNode tempNode = start;
		ListNode prev = null;
		while (start != null) {
			if (start.getData().equals(data)) {
				prev.setNext(start.getNext());
				start.setNext(null);
				start = tempNode;
				size--;
				return;
			}
			prev = start;
			start = start.getNext();
		}
	}
}