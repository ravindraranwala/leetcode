package com.coding.challenge.string;

import java.util.HashSet;
import java.util.Set;

class CountTheNumberOfSpecialCharactersI {
	CountTheNumberOfSpecialCharactersI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert numberOfSpecialChars("aaAbcBC") == 3;
		assert numberOfSpecialChars("abc") == 0;
		assert numberOfSpecialChars("abBCab") == 1;
	}

	static int numberOfSpecialChars(String word) {
		final Set<Character> lowerSet = new HashSet<>();
		final Set<Character> upperSet = new HashSet<>();
		for (char ch : word.toCharArray()) {
			if (Character.isLowerCase(ch))
				lowerSet.add(ch);
			else
				upperSet.add(ch);
		}

		int cnt = 0;
		for (Character ch : upperSet)
			if (lowerSet.contains(Character.toLowerCase(ch)))
				cnt = cnt + 1;

		return cnt;
	}
}
