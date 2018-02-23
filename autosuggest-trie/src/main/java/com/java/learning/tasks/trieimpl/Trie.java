package com.java.learning.tasks.trieimpl;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Trie{

	private static final Logger logger = Logger.getLogger(Trie.class.getName());
	private TrieNode root;

	public TrieNode getRoot() {
		return root;
	}

	public void setRoot(TrieNode root) {
		this.root = root;
	}

	public Trie(){
		root = new TrieNode(' ');
	}

	/**
	 * method is responsible to search weather a word exist in trie or not
	 * @param word
	 * @return
	 */
	public TrieNode searchWord(String word){
		if(null != word){
			TrieNode current = root;
			TrieNode child = null;
			for(char ch : word.toCharArray()){
				if( (child=current.getChildNode(ch)) != null){
					current = child;
				}else{
					return null;
				}
			}
			if(current.isEndFlag()){
				return current;
			}
		}
		return null;
	}

	/**
	 * Method is responsible to insert a words into trie, if word already exist in trie will increase word count by 1
	 * @param word
	 */
	public void insertWord(String word) {
		TrieNode child = null;
		if ((child = searchWord(word)) != null) {
			child.setCount(child.getCount() + 1);
			return;
		}
		child = root;
		TrieNode nextChild = null;
		for (char ch : word.toCharArray()) {
			nextChild = child.getChildNode(ch);
			if (nextChild != null && !nextChild.isEndFlag()) {
				child = nextChild;
			} else {
				child.getChildNodes().add(new TrieNode(ch));
				child = child.getChildNode(ch);
			}
		}
		child.setEndFlag(true);
		child.setCount(1);
	}

	/**
	 * it will remove the word from trie if word exists
	 * @param word
	 */
	public void removeWord(String word){
		TrieNode child = null;
		if ((child = searchWord(word)) == null) {
			throw new RuntimeException("Word not found in trie structure");
		}
		child = root;
		for(char ch : word.toCharArray()){
			TrieNode newChild = child.getChildNode(ch);
			if(newChild.getCount() == 1){
				child.getChildNodes().remove(child);
				return;
			}else{
				newChild.setCount(newChild.getCount() -1 );
				child = newChild;
			}
		}
		child.setEndFlag(false);
	}

	/**\
	 * This will return Map of all words in trie with their count.
	 * @return
	 */
	public Map<String, Integer> getWordList() {
		Map<String, Integer> result = new HashMap<>();
		for (TrieNode child : root.getChildNodes()) {
			if (null != child) {
				getWordList(result, child.getData() + "", child);
			}
		}
		return result;
	}

	/**
	 * this will return words by prefix combination from existing trie
	 * @param prefix
	 * @return
	 */
	public Map<String, Integer> prefixSearch(String prefix) {
		Map<String, Integer> result = new HashMap<>();
		TrieNode child = root;
		TrieNode nextChild = null;
		String word = new String();
		for (char ch : prefix.toCharArray()) {
			nextChild = child.getChildNode(ch);
			if (nextChild != null && !nextChild.isEndFlag()) {
				child = nextChild;
				word = word+""+nextChild.getData()+"";
			}else if(nextChild.isEndFlag()){
				result.put(word, nextChild.getCount());
			}
		}
		if(child != null && !child.isEndFlag()){
			getWordList(result, word, child);
		}
		return result;
	}
	/**
	 * Description: this function is the recursive portion of the
	 *    overloaded function above.
	 *
	 *   0] if the given node child is a word, add the word to the result
	 *   1] if child is a prefix, for each of its children
	 *      call this recursive function getWordList to assemble
	 *      all words stemming from the given child.
	 */
	private void getWordList(Map<String, Integer> result, String word, TrieNode child) {
		if (child.isEndFlag()) {
			result.put(word, child.getCount());
		}
		for (TrieNode t : child.getChildNodes()) {
			if (null != t) {
				getWordList(result, word + t.getData(), t);
			}
		}
	}
}