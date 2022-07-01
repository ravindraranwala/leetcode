package com.coding.challenge.general;

import java.util.HashMap;
import java.util.Map;

public class MinStepsToMakeAnagrams {
	private static final int ALPHABET_SIZE = 26;

	MinStepsToMakeAnagrams() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		int steps = minStepsV2("bab", "aba");
		assert steps == 1;

		steps = minStepsV2("leetcode", "practice");
		assert steps == 5;

		steps = minStepsV2("anagram", "mangaar");
		assert steps == 0;
	}

	static int minSteps(String s, String t) {
		final Map<Character, Integer> f = new HashMap<>();
		for (char ch : s.toCharArray())
			f.merge(ch, 1, Integer::sum);

		int steps = 0;
		for (char ch : t.toCharArray()) {
			if (f.getOrDefault(ch, 0) > 0)
				f.put(ch, f.get(ch) - 1);
			else
				steps = steps + 1;
		}

		return steps;
	}

	static int minStepsV2(String s, String t) {
		final int[] f = new int[ALPHABET_SIZE];
		for (int i = 0; i < ALPHABET_SIZE; i++)
			f[i] = 0;
		for (char ch : s.toCharArray())
			f[ch - 'a'] = f[ch - 'a'] + 1;

		int steps = 0;
		for (char ch : t.toCharArray()) {
			if (f[ch - 'a'] > 0)
				f[ch - 'a'] = f[ch - 'a'] - 1;
			else
				steps = steps + 1;
		}
		return steps;
	}
}
