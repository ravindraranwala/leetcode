package com.coding.challenge.sliding.window;

class SubstrsContainingAllChars {
	SubstrsContainingAllChars() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		int n = numberOfSubstrings("abcabc");
		assert n == 10;

		n = numberOfSubstrings("aaacb");
		assert n == 3;

		n = numberOfSubstrings("abc");
		assert n == 1;

		n = numberOfSubstrings("aab");
		assert n == 0;

		n = numberOfSubstrings("ababbbc");
		assert n == 3;
	}

	static int numberOfSubstrings(String s) {
		final int n = s.length();
		final int[] p = { -1, -1, -1 };
		int i = 0;
		int j = 0;
		int c = 0;

		while (i < n) {
			if (p[0] >= i && p[1] >= i && p[2] >= i) {
				c = c + n - j + 1;
				i = i + 1;
			} else if (j < n) {
				final char ch = s.charAt(j);
				p[ch - 'a'] = j;
				j = j + 1;
			} else
				i = i + 1;
		}
		return c;
	}
}
