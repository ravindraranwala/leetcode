package com.coding.challenge.two.pointer;

import java.util.Arrays;

class StringReverse {
	StringReverse() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final char[] strOne = { 'h', 'e', 'l', 'l', 'o' };
		reverseString(strOne);
		assert Arrays.equals(strOne, "olleh".toCharArray());

		final char[] strTwo = { 'H', 'a', 'n', 'n', 'a', 'h' };
		reverseString(strTwo);
		assert Arrays.equals(strTwo, "hannaH".toCharArray());
	}

	static void reverseString(char[] s) {
		final int n = s.length;
		final int m = (int) Math.ceil(n / 2.0);
		// implicit two pointer approach, the second pointer is a derived one.
		for (int i = 0; i < m; i++) {
			// exchange
			final char tmp = s[i];
			s[i] = s[n - i - 1];
			s[n - i - 1] = tmp;
		}
	}
}
