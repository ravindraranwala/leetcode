package com.coding.challenge.hash.table;

class MaximumDifferenceBetweenEvenAndOddFrequencyI {
	private static final char FIRST_LETTER = 'a';

	MaximumDifferenceBetweenEvenAndOddFrequencyI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maxDifference("aaaaabbc") == 3;
		assert maxDifference("abcabcab") == 1;
		assert maxDifference("aaaabbccccdde") == -1;
	}

	static int maxDifference(String s) {
		final int[] f = new int[26];
		for (char ch : s.toCharArray())
			f[ch - FIRST_LETTER] = f[ch - FIRST_LETTER] + 1;

		int maxOddFreq = 1;
		int minEvenFreq = Integer.MAX_VALUE - 1;
		for (int freq : f) {
			if (freq % 2 == 1)
				maxOddFreq = Math.max(maxOddFreq, freq);
			else if (freq > 0)
				minEvenFreq = Math.min(minEvenFreq, freq);
		}
		return maxOddFreq - minEvenFreq;
	}
}
