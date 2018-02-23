package com.java.learning.tasks.trieimpl;

import java.util.LinkedList;

/**
 * TrieNode class, which has information of trie data node information
 *
 * @author pappuy
 */
public class TrieNode{
	private LinkedList<TrieNode> childNodes;
	private char data;
	private boolean endFlag;
	private int count;

	public TrieNode(char data){
		childNodes = new LinkedList<TrieNode>();
		this.data = data;
		this.endFlag = false;
		this.count = 0;
	}

	public TrieNode getChildNode(char data){
		if(childNodes != null){
			for(TrieNode childNode : childNodes){
				if(data == childNode.data){
					return childNode;
				}
			}
		}
		return null;
	}

	public LinkedList<TrieNode> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(LinkedList<TrieNode> childNodes) {
		this.childNodes = childNodes;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public boolean isEndFlag() {
		return endFlag;
	}

	public void setEndFlag(boolean endFlag) {
		this.endFlag = endFlag;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}