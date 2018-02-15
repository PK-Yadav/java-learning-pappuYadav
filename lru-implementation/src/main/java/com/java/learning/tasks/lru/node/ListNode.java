package com.java.learning.tasks.lru.node;

/**
 * LinkList node class, has node information.
 *
 * @author pappuy
 */
public class ListNode{
	private String data;
	private ListNode next;

	public ListNode(){
		this.data = null;
		this.next = null;
	}

	public ListNode(String data, ListNode next){
		this.data = data;
		this.next= next;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}
}