package com.coding.challenge.two.pointer;

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

		for (int j = 1, i = -1; j < n; j++) {
			final char ch = s.charAt(j);
			if (ch != s.charAt(j - 1)) {
				c = c + 1;
				i = j - 1;
			} else if (i > 0 && ch != s.charAt(i - 1)) {
				c = c + 1;
				i = i - 1;
			} else
				i = -1;
		}
		return c;
	}
}
