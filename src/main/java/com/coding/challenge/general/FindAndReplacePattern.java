package com.coding.challenge.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FindAndReplacePattern {
	FindAndReplacePattern() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] wordsOne = { "abc", "deq", "mee", "aqq", "dkd", "ccc" };
		System.out.println(findAndReplacePattern(wordsOne, "abb"));

		final String[] wordsTwo = { "a", "b", "c" };
		System.out.println(findAndReplacePattern(wordsTwo, "a"));
	}

	static List<String> findAndReplacePattern(String[] words, String pattern) {
		final List<String> m = new ArrayList<>();
		final int l = pattern.length();
		for (String w : words) {
			// checking for a bijection (one to one and on to) relation in two sets.
			final Map<Character, Character> patternToWord = new HashMap<>();
			final Map<Character, Character> wordToPattern = new HashMap<>();
			boolean match = true;
			for (int i = 0; match && i < l; i++) {
				if (patternToWord.containsKey(pattern.charAt(i)))
					match = match && patternToWord.get(pattern.charAt(i)) == w.charAt(i);

				if (wordToPattern.containsKey(w.charAt(i)))
					match = match && wordToPattern.get(w.charAt(i)) == pattern.charAt(i);

				wordToPattern.put(w.charAt(i), pattern.charAt(i));
				patternToWord.put(pattern.charAt(i), w.charAt(i));
			}
			if (match)
				m.add(w);
		}
		return m;
	}
}
