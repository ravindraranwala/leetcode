package com.coding.challenge.dp;

class DeleteOperationForTwoStrings {
	DeleteOperationForTwoStrings() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minDistance("sea", "eat") == 2;

		assert minDistance("leetcode", "etco") == 4;
	}

	static int minDistance(String word1, String word2) {
		final int m = word1.length();
		final int n = word2.length();
		final int l = LCS.lcsLength(word1, word2);
		return m - l + n - l;
	}
}
