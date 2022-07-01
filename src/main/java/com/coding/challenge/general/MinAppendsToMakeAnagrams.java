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
		final Map<Character, Integer> f = new HashMap<>();
		for (char ch : s.toCharArray())
			f.merge(ch, 1, Integer::sum);

		int common = 0;
		for (char ch : t.toCharArray()) {
			if (f.getOrDefault(ch, 0) > 0) {
				common = common + 1;
				f.put(ch, f.get(ch) - 1);
			}
		}
		return s.length() + t.length() - 2 * common;
	}

	static int minStepsV2(String s, String t) {
		final int[] f = new int[ALPHABET_SIZE];
		for (int i = 0; i < ALPHABET_SIZE; i++)
			f[i] = 0;
		for (char ch : s.toCharArray())
			f[ch - 'a'] = f[ch - 'a'] + 1;

		int common = 0;
		for (char ch : t.toCharArray()) {
			if (f[ch - 'a'] > 0) {
				common = common + 1;
				f[ch - 'a'] = f[ch - 'a'] - 1;
			}
		}
		return s.length() + t.length() - 2 * common;
	}
}
