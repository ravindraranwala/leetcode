package com.coding.challenge.trie;

class TrieTest {
	TrieTest() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// test case one
		final Trie trieOne = new Trie();
		trieOne.insert("apple");
		assert trieOne.search("apple"); // return True
		assert !trieOne.search("app"); // return False
		assert trieOne.startsWith("app"); // return True
		trieOne.insert("app");
		assert trieOne.search("app"); // return True

		// test case two.
		final Trie trieTwo = new Trie();
		trieTwo.insert("a");
		assert trieTwo.search("a"); // return True
		assert trieTwo.startsWith("a");// return True
	}

}
