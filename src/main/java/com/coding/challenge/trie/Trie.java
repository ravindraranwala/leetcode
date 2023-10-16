package com.coding.challenge.trie;

public class Trie {
	private static final char FIRST_LETTER = 'a';
	private final TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		insertRec(word, 0, root, word.length());
	}

	private void insertRec(String word, int i, TrieNode node, int n) {
		if (i == n) {
			node.word = true;
			return;
		}
		if (node.children[word.charAt(i) - FIRST_LETTER] == null)
			node.children[word.charAt(i) - FIRST_LETTER] = new TrieNode();
		insertRec(word, i + 1, node.children[word.charAt(i) - FIRST_LETTER], n);
	}

	public boolean search(String word) {
		return searchRec(word, 0, root, word.length());
	}

	private boolean searchRec(String word, int i, TrieNode node, int n) {
		if (i == n)
			return node.word;
		if (node.children[word.charAt(i) - FIRST_LETTER] == null)
			return false;
		return searchRec(word, i + 1, node.children[word.charAt(i) - FIRST_LETTER], n);
	}

	public boolean startsWith(String prefix) {
		return startsWithRec(prefix, 0, root, prefix.length());

	}

	public String root(String word) {
		return findRoot(word, 0, root, word.length());
	}
	
	private static String findRoot(String word, int i, TrieNode node, int n) {
		if (i == n)
			return "";
		if (node.children[word.charAt(i) - FIRST_LETTER] == null)
			return "";
		if (node.children[word.charAt(i) - FIRST_LETTER].word)
			return word.substring(0, i + 1);
		return findRoot(word, i + 1, node.children[word.charAt(i) - FIRST_LETTER], n);
	}

	private boolean startsWithRec(String word, int i, TrieNode node, int n) {
		if (i == n)
			return true;
		if (node.children[word.charAt(i) - FIRST_LETTER] == null)
			return false;
		return startsWithRec(word, i + 1, node.children[word.charAt(i) - FIRST_LETTER], n);
	}

	private static class TrieNode {
		private final TrieNode[] children;
		private boolean word;

		public TrieNode() {
			children = new TrieNode[26];
			word = false;
		}
	}
}
