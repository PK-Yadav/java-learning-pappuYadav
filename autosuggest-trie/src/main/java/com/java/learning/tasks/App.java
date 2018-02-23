package com.java.learning.tasks;

import com.java.learning.tasks.trieimpl.Trie;

import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /* Creating object of AATree */
        Trie root = new Trie();
        System.out.println("Trie Test\n");
        char ch;
        /*  Perform tree operations  */
        do {
            System.out.println("\nTrie Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. delete");
            System.out.println("3. search");
            System.out.println("4. prefix search");
            System.out.println("5. display");

            int choice = scan.nextInt();
            switch (choice) {
            case 1:
                System.out.println("Enter string element to insert");
                root.insertWord(scan.next());
                break;
            case 2:
                System.out.println("Enter string element to delete");
                try {
                    root.removeWord(scan.next());
                } catch (Exception e) {
                    System.out.println(e.getMessage() + " not found ");
                }
                break;
            case 3:
                System.out.println("Enter string element to search");
                System.out.println("Search result : " + root.searchWord(scan.next()));
                break;
            case 4 :
                System.out.println("Enter string element to prefix search");
                Map<String, Integer> prefixResult = root.prefixSearch(scan.next());
                System.out.println("Search result : ");
                for(Map.Entry<String, Integer> map : prefixResult.entrySet()){
                    System.out.println(map.getKey());
                }
                break;
            case 5 :
                System.out.println("Enter string element to display all words from trie");
                Map<String, Integer> words = root.getWordList();
                System.out.println("Search result : ");
                for(Map.Entry<String, Integer> map : words.entrySet()){
                    System.out.println(map.getKey());
                }
                break;
            default:
                System.out.println("Wrong Entry \n ");
                break;
            }

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        }
        while (ch == 'Y' || ch == 'y');
    }

    /*public static void main(String []args){
        Trie root = new Trie();
        root.insertWord("hello");
        root.insertWord("main");
        root.insertWord("hello");
        root.insertWord("hey");
        root.insertWord("heman");
        if(null != root.searchWord("hello")){
            System.out.println("Word hello exists in trie");
        }else{
            System.out.println("Word hello doesn't exists in trie");
        }

        Map<String, Integer> words = root.prefixSearch("he");

        for (Map.Entry<String, Integer> map : words.entrySet()){
            System.out.println(map.getKey() +" : " + map.getValue());
        }
    }
*/
}