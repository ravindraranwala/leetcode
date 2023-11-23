package com.coding.challenge.hash.table;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class LongestWordInDictionary {
	LongestWordInDictionary() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] wordsOne = { "w", "wo", "wor", "worl", "world" };
		assert "world".equals(longestWord(wordsOne));

		final String[] wordsTwo = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
		assert "apple".equals(longestWord(wordsTwo));

		final String[] wordsThree = { "yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod",
				"ewqz", "y" };
		assert "yodn".equals(longestWord(wordsThree));
	}

	static String longestWord(String[] words) {
		final Comparator<String> cmp = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				final int c = Integer.compare(s1.length(), s2.length());
				if (c == 0)
					return s2.compareTo(s1);
				return c;
			}
		};

		Arrays.sort(words, cmp);
		final Set<String> tokens = new HashSet<>();
		// sentinel value
		tokens.add("");
		int k = -1;
		final int n = words.length;
		for (int i = 0; i < n; i++) {
			if (tokens.contains(words[i].substring(0, words[i].length() - 1))) {
				k = i;
				tokens.add(words[i]);
			}
		}
		return k == -1 ? "" : words[k];
	}
}
