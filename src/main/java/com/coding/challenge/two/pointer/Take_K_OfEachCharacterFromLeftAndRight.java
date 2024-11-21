package com.coding.challenge.two.pointer;

class Take_K_OfEachCharacterFromLeftAndRight {
	private static final char FIRST_LETTER = 'a';

	Take_K_OfEachCharacterFromLeftAndRight() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert takeCharacters("aabaaaacaabc", 2) == 8;
		assert takeCharacters("a", 1) == -1;
		assert takeCharacters("a", 0) == 0;
		assert takeCharacters("cbbac", 1) == 3;
		assert takeCharacters("bcca", 1) == 3;
	}

	static int takeCharacters(String s, int k) {
		if (k == 0)
			return 0;

		final int[] c = new int[3];
		final int n = s.length();
		int j = n - 1;
		while (j >= 0 && (c[0] < k || c[1] < k || c[2] < k)) {
			final char ch = s.charAt(j);
			c[ch - FIRST_LETTER] = c[ch - FIRST_LETTER] + 1;
			j = j - 1;
		}

		// no solution exists.
		if (c[0] < k || c[1] < k || c[2] < k)
			return -1;

		j = j + 1;
		int l = n - j;
		// two pointer technique.
		for (int i = 0; i < n; i++) {
			final char ch = s.charAt(i);
			c[ch - FIRST_LETTER] = c[ch - FIRST_LETTER] + 1;
			while (j < n && c[s.charAt(j) - FIRST_LETTER] > k) {
				c[s.charAt(j) - FIRST_LETTER] = c[s.charAt(j) - FIRST_LETTER] - 1;
				j = j + 1;
			}
			l = Math.min(l, n - j + i + 1);
		}
		return l;
	}
}
