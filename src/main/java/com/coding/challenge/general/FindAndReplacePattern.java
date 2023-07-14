package com.coding.challenge.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindAndReplacePattern {
	private static final char FIRST_LETTER = 'a';

	FindAndReplacePattern() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] wordsOne = { "abc", "deq", "mee", "aqq", "dkd", "ccc" };
		assert Arrays.asList("mee", "aqq").equals(findAndReplacePattern(wordsOne, "abb"));

		final String[] wordsTwo = { "a", "b", "c" };
		assert Arrays.asList("a", "b", "c").equals(findAndReplacePattern(wordsTwo, "a"));
	}

	static List<String> findAndReplacePattern(String[] words, String pattern) {
		final List<String> m = new ArrayList<>();
		final int l = pattern.length();
		for (String w : words) {
			// checking for a bijection (one to one and on to) relation in two sets.
			final int[] patternToWord = new int[26];
			final int[] wordToPattern = new int[26];
			boolean match = true;
			for (int i = 0; match && i < l; i++) {
				if (patternToWord[pattern.charAt(i) - FIRST_LETTER] != 0)
					match = match && patternToWord[pattern.charAt(i) - FIRST_LETTER] == w.charAt(i);

				if (wordToPattern[w.charAt(i) - FIRST_LETTER] != 0)
					match = match && wordToPattern[w.charAt(i) - FIRST_LETTER] == pattern.charAt(i);

				wordToPattern[w.charAt(i) - FIRST_LETTER] = pattern.charAt(i);
				patternToWord[pattern.charAt(i) - FIRST_LETTER] = w.charAt(i);
			}
			if (match)
				m.add(w);
		}
		return m;
	}
}
