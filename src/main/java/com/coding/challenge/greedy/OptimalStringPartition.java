package com.coding.challenge.greedy;

class OptimalStringPartition {
	private static final char FIRST_LETTER = 'a';

	OptimalStringPartition() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert partitionString("abacaba") == 4;

		assert partitionString("ssssss") == 6;
	}

	static int partitionString(String s) {
		final int n = s.length();
		int cnt = 0;
		int[] freq = new int[26];

		for (int j = 0; j < n; j++) {
			if (freq[s.charAt(j) - FIRST_LETTER] > 0) {
				cnt = cnt + 1;
				freq = new int[26];
			}
			freq[s.charAt(j) - FIRST_LETTER] = freq[s.charAt(j) - FIRST_LETTER] + 1;
		}
		// make sure that you count the remaining window when you terminate the loop.
		return cnt + 1;
	}
}
