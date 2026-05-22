package com.coding.challenge.trie;

class FindTheLengthOfTheLongestCommonPrefix {

	FindTheLengthOfTheLongestCommonPrefix() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 1, 10, 100 };
		final int[] arr2 = { 1000 };
		assert longestCommonPrefix(arr1, arr2) == 3;

		final int[] arr3 = { 1, 2, 3 };
		final int[] arr4 = { 4, 4, 4 };
		assert longestCommonPrefix(arr3, arr4) == 0;
	}

	static int longestCommonPrefix(int[] arr1, int[] arr2) {
		final Trie trie = new Trie();
		for (int val2 : arr2)
			trie.insert(String.valueOf(val2));

		int maxLen = 0;
		for (int val1 : arr1)
			maxLen = Math.max(maxLen, trie.search(String.valueOf(val1)));

		return maxLen;
	}

	static class Trie {
		private final TrieNode root;
		private static final char ZERO = '0';

		Trie() {
			root = new TrieNode();
		}

		void insert(String num) {
			TrieNode curr = root;
			for (char ch : num.toCharArray()) {
				final int offset = ch - ZERO;
				if (curr.children[offset] == null)
					curr.children[offset] = new TrieNode();

				curr = curr.children[offset];
			}
		}

		int search(String num) {
			int d = 0;
			TrieNode curr = root;
			for (char ch : num.toCharArray()) {
				final int offset = ch - ZERO;
				if (curr.children[offset] == null)
					return d;

				d = d + 1;
				curr = curr.children[offset];
			}
			return d;
		}

		static class TrieNode {
			final TrieNode[] children;

			TrieNode() {
				children = new TrieNode[10];
			}
		}
	}
}
