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
		final int n = key.length();
		TrieNode curr = root;
		for (int i = 0; i < n; i++) {
			final char ch = key.charAt(i);
			if (curr.children[ch - FIRST_LETTER] == null)
				curr.children[ch - FIRST_LETTER] = new TrieNode();
			curr = curr.children[ch - FIRST_LETTER];
			curr.sum = curr.sum - oldValue + val;
		}
		keyStore.put(key, val);
	}

	public int sum(String prefix) {
		final int n = prefix.length();
		TrieNode curr = root;
		for (int i = 0; i < n && curr != null; i++) {
			final char ch = prefix.charAt(i);
			curr = curr.children[ch - FIRST_LETTER];
		}
		return curr == null ? 0 : curr.sum;
	}

	private static class TrieNode {
		private TrieNode[] children = new TrieNode[26];
		private int sum = 0;

		TrieNode() {

		}
	}
}
