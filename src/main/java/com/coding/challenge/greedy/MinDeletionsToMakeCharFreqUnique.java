package com.coding.challenge.greedy;

import java.util.HashSet;
import java.util.Set;

class MinDeletionsToMakeCharFreqUnique {
	private static final char FIRST_LETTER = 'a';

	MinDeletionsToMakeCharFreqUnique() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String s1 = "aab";
		assert minDeletions(s1) == 0;

		final String s2 = "aaabbbcc";
		assert minDeletions(s2) == 2;

		final String s3 = "ceabaacb";
		assert minDeletions(s3) == 2;
	}

	static int minDeletions(String s) {
		final int[] chFreq = new int[26];
		for (char ch : s.toCharArray())
			chFreq[ch - FIRST_LETTER] = chFreq[ch - FIRST_LETTER] + 1;

		final Set<Integer> f = new HashSet<>();
		int d = 0;
		for (int v : chFreq) {
			int freq = v;
			while (f.contains(freq))
				freq = freq - 1;

			if (freq > 0)
				f.add(freq);
			d = d + v - freq;
		}
		return d;
	}
}
