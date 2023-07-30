package com.coding.challenge.dp;

import java.util.Arrays;

class LongestStringChain {
	LongestStringChain() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] wordsOne = { "a", "b", "ba", "bca", "bda", "bdca" };
		assert longestStrChain(wordsOne) == 4;

		final String[] wordsTwo = { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" };
		assert longestStrChain(wordsTwo) == 5;

		final String[] wordsThree = { "abcd", "dbqca" };
		assert longestStrChain(wordsThree) == 1;
	}

	static int longestStrChain(String[] words) {
		Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
		int l = 1;
		final int n = words.length;
		final int[] chainLen = new int[n];

		for (int i = 0; i < n; i++) {
			chainLen[i] = 1;
			for (int j = 0; j < i; j++)
				if (predecessor(words[j], words[i]))
					chainLen[i] = Math.max(chainLen[i], chainLen[j] + 1);

			l = Math.max(l, chainLen[i]);
		}
		return l;
	}

	private static boolean predecessor(String s, String t) {
		final int n = t.length();
		if (s.length() + 1 != n)
			return false;

		// two-pointer approach used to determine whether s is a predecessor of t.
		int i = 0;
		for (int j = 0; j < n && i < n - 1; j++) {
			if (s.charAt(i) == t.charAt(j))
				i = i + 1;
		}
		return i == n - 1;
	}
}
