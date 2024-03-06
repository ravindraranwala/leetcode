package com.coding.challenge.trie;

import java.util.HashMap;
import java.util.Map;

class MapSum {
	private static final char FIRST_LETTER = 'a';
	private final TrieNode root = new TrieNode();
	private final Map<String, Integer> keyStore = new HashMap<>();

	MapSum() {
	}

	public static void main(String[] args) {
		final MapSum mapSum = new MapSum();
		mapSum.insert("apple", 3);
		assert mapSum.sum("ap") == 3; // return 3 (apple = 3)
		mapSum.insert("app", 2);
		assert mapSum.sum("ap") == 5;
		assert mapSum.sum("apple") == 3;
		mapSum.insert("app", 4);
		assert mapSum.sum("app") == 7;
	}

	public void insert(String key, int val) {
		final int oldValue = keyStore.getOrDefault(key, 0);
		TrieNode curr = root;
		for (char ch : key.toCharArray()) {
			if (curr.children[ch - FIRST_LETTER] == null)
				curr.children[ch - FIRST_LETTER] = new TrieNode();
			curr = curr.children[ch - FIRST_LETTER];
			curr.sum = curr.sum - oldValue + val;
		}
		keyStore.put(key, val);
	}

	public int sum(String prefix) {
		TrieNode curr = root;
		for (char ch : prefix.toCharArray()) {
			curr = curr.children[ch - FIRST_LETTER];
			if (curr == null)
				return 0;
		}
		return curr.sum;
	}

	private static class TrieNode {
		private TrieNode[] children = new TrieNode[26];
		private int sum = 0;

		TrieNode() {

		}
	}
}
