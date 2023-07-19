package com.coding.challenge.trie;

public class TrieTest {

	public static void main(String[] args) {
		// test case one
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple")); // return True
		System.out.println(trie.search("app")); // return False
		System.out.println(trie.startsWith("app")); // return True
		trie.insert("app");
		System.out.println(trie.search("app")); // return True

		System.out.println("=======================");
		// test case two.
		final Trie trieTwo = new Trie();
		trieTwo.insert("a");
		System.out.println(trieTwo.search("a"));
		System.out.println(trieTwo.startsWith("a"));
	}

}
