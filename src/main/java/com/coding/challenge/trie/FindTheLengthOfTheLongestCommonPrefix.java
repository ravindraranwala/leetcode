package com.coding.challenge.trie;

class FindTheLengthOfTheLongestCommonPrefix {
	private static final char ZERO = '0';
	private final TrieNode root = new TrieNode();

	FindTheLengthOfTheLongestCommonPrefix() {
	}

	public static void main(String[] args) {
		final int[] arr1 = { 1, 10, 100 };
		final int[] arr2 = { 1000 };
		assert new FindTheLengthOfTheLongestCommonPrefix().longestCommonPrefix(arr1, arr2) == 3;

		final int[] arr3 = { 1, 2, 3 };
		final int[] arr4 = { 4, 4, 4 };
		assert new FindTheLengthOfTheLongestCommonPrefix().longestCommonPrefix(arr3, arr4) == 0;

		final int[] arr5 = { 1, 26 };
		final int[] arr6 = { 22, 2 };
		assert new FindTheLengthOfTheLongestCommonPrefix().longestCommonPrefix(arr5, arr6) == 1;
	}

	int longestCommonPrefix(int[] arr1, int[] arr2) {
		for (int num1 : arr1)
			addWord(num1 + "");
		int l = 0;
		for (int num2 : arr2)
			l = Math.max(l, search(num2 + ""));

		return l;
	}

	void addWord(String word) {
		final int n = word.length();
		TrieNode curr = root;
		for (int i = 0; i < n; i++) {
			if (curr.children[word.charAt(i) - ZERO] == null)
				curr.children[word.charAt(i) - ZERO] = new TrieNode();

			curr = curr.children[word.charAt(i) - ZERO];
		}
	}

	int search(String word) {
		final int n = word.length();
		int i = 0;
		TrieNode curr = root;
		while (i < n && curr.children[word.charAt(i) - ZERO] != null) {
			curr = curr.children[word.charAt(i) - ZERO];
			i = i + 1;
		}
		return i;
	}

	static class TrieNode {
		private final TrieNode[] children = new TrieNode[10];
	}
}
