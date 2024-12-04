package com.coding.challenge.two.pointer;

class MakeStringSubsequenceUsingCyclicIncrements {
	private static final char FIRST_LETTER = 'a';

	MakeStringSubsequenceUsingCyclicIncrements() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert canMakeSubsequence("abc", "ad");
		assert canMakeSubsequence("zc", "ad");
		assert !canMakeSubsequence("ab", "d");
	}

	static boolean canMakeSubsequence(String str1, String str2) {
		final int m = str1.length();
		final int n = str2.length();

		for (int i = 0, j = 0; i < m; i++) {
			final char ch1 = str1.charAt(i);
			final char ch2 = str2.charAt(j);
			final char nextCh = (char) (FIRST_LETTER + ((ch1 - FIRST_LETTER + 1) % 26));
			if (ch1 == ch2 || nextCh == ch2)
				j = j + 1;
			if (j == n)
				return true;
		}
		return false;
	}
}
