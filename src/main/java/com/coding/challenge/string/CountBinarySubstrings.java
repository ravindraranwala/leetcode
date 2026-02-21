package com.coding.challenge.string;

class CountBinarySubstrings {

	CountBinarySubstrings() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert countBinarySubstrings("00110011") == 6;
		assert countBinarySubstrings("10101") == 4;
		assert countBinarySubstrings("0001111") == 3;
	}

	static int countBinarySubstrings(String s) {
		final int n = s.length();
		int c = 0;

		for (int i = 1, l = 0; i < n; i++) {
			final char ch = s.charAt(i);
			if (ch != s.charAt(i - 1)) {
				c = c + 1;
				l = 1;
			} else if (i > 2 * l && ch != s.charAt(i - 2 * l - 1)) {
				c = c + 1;
				l = l + 1;
			} else
				l = 0;
		}
		return c;
	}
}
