package com.coding.challenge.hash.table;

import java.util.ArrayList;
import java.util.List;

class WordSubsets {
	private static final char FIRST_LETTER = 'a';

	WordSubsets() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] words1 = { "amazon", "apple", "facebook", "google", "leetcode" };
		final String[] words2 = { "e", "o" };
		System.out.println(wordSubsets(words1, words2));

		final String[] words3 = { "amazon", "apple", "facebook", "google", "leetcode" };
		final String[] words4 = { "l", "e" };
		System.out.println(wordSubsets(words3, words4));
	}

	static List<String> wordSubsets(String[] words1, String[] words2) {
		final int[] maxFreq = new int[26];
		for (String word : words2) {
			final int[] currFreq = charFreq(word);
			for (int i = 0; i < 26; i++)
				maxFreq[i] = Math.max(maxFreq[i], currFreq[i]);
		}

		final List<String> l = new ArrayList<>();
		for (String word : words1) {
			final int[] f = charFreq(word);
			int i = 0;
			while (i < 26 && f[i] >= maxFreq[i])
				i = i + 1;

			if (i == 26)
				l.add(word);
		}
		return l;
	}

	private static int[] charFreq(String word) {
		final int[] currFreq = new int[26];
		for (char ch : word.toCharArray())
			currFreq[ch - FIRST_LETTER] = currFreq[ch - FIRST_LETTER] + 1;
		return currFreq;
	}
}
