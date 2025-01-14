package com.coding.challenge.hash.table;

class MinimumLengthOfStringAfterOperations {
	private static final char FIRST_LETTER = 'a';

	MinimumLengthOfStringAfterOperations() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minimumLength("abaacbcbb") == 5;
		assert minimumLength("aa") == 2;
	}

	static int minimumLength(String s) {
		final int[] f = new int[26];
		for (char ch : s.toCharArray())
			f[ch - FIRST_LETTER] = f[ch - FIRST_LETTER] + 1;

		int l = 0;
		for (int i = 0; i < 26; i++) {
			if (f[i] > 0) {
				if (f[i] % 2 == 0)
					l = l + 2;
				else
					l = l + 1;
			}
		}

		return l;
	}
}
