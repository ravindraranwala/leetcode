package com.coding.challenge.dp;

class CountUniqueCharactersOfAllSubstrings {
	private static final char A = 'A';

	CountUniqueCharactersOfAllSubstrings() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String strOne = "ABC";
		assert uniqueLetterString(strOne) == 10;

		final String strTwo = "ABA";
		assert uniqueLetterString(strTwo) == 8;

		final String strThree = "LEETCODE";
		assert uniqueLetterString(strThree) == 92;
	}

	static int uniqueLetterString(String s) {
		final int n = s.length();
		final int[] p = new int[26];
		final int[] d = new int[26];
		int ans = 0;

		for (int i = 1, c = 0; i <= n; i++) {
			final char ch = s.charAt(i - 1);
			final int j = p[ch - A];
			c = c + i - j - d[ch - A];
			ans = ans + c;
			d[ch - A] = i - j;
			p[ch - A] = i;
		}
		return ans;
	}
}
