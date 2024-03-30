package com.coding.challenge.hash.table;

import java.util.ArrayList;
import java.util.List;

class FindCommonCharacters {
	private static final char FIRST_LETTER = 'a';

	FindCommonCharacters() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] words1 = { "bella", "label", "roller" };
		System.out.println(commonChars(words1));

		final String[] words2 = { "cool", "lock", "cook" };
		System.out.println(commonChars(words2));
	}

	static List<String> commonChars(String[] words) {
		final int n = words.length;
		final int[] f = new int[26];
		for (int i = 0; i < 26; i++)
			f[i] = 101;
		for (int i = 0; i < n; i++) {
			final int[] a = new int[26];
			for (char ch : words[i].toCharArray())
				a[ch - FIRST_LETTER] = a[ch - FIRST_LETTER] + 1;

			for (int j = 0; j < 26; j++)
				f[j] = Math.min(f[j], a[j]);
		}

		final List<String> l = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			final char ch = (char) (FIRST_LETTER + i);
			for (int j = 0; j < f[i]; j++)
				l.add(String.valueOf(ch));
		}
		return l;
	}
}
