package com.coding.challenge.general;

import java.util.HashMap;
import java.util.Map;

class MinAppendsToMakeAnagrams {
	private static final int ALPHABET_SIZE = 26;

	MinAppendsToMakeAnagrams() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		int appends = minStepsV2("leetcode", "coats");
		assert appends == 7;
		
		appends = minStepsV2("night", "thing");
		assert appends == 0;
	}

	static int minSteps(String s, String t) {
		final Map<Character, Integer> charCnt = new HashMap<>();
		for (char ch : s.toCharArray())
			charCnt.merge(ch, 1, Integer::sum);

		int common = 0;
		for (char ch : t.toCharArray()) {
			if (charCnt.getOrDefault(ch, 0) > 0) {
				common = common + 1;
				charCnt.put(ch, charCnt.get(ch) - 1);
			}
		}
		return s.length() + t.length() - 2 * common;
	}

	static int minStepsV2(String s, String t) {
		final int[] charCnt = new int[ALPHABET_SIZE];
		for (int i = 0; i < ALPHABET_SIZE; i++)
			charCnt[i] = 0;
		for (char ch : s.toCharArray())
			charCnt[ch - 'a'] = charCnt[ch - 'a'] + 1;

		int common = 0;
		for (char ch : t.toCharArray()) {
			if (charCnt[ch - 'a'] > 0) {
				common = common + 1;
				charCnt[ch - 'a'] = charCnt[ch - 'a'] - 1;
			}
		}
		return s.length() + t.length() - 2 * common;
	}
}
