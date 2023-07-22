package com.coding.challenge.math;

import java.util.Arrays;

class DivisibilityArrayOfString {
	private static final char ZERO = '0';

	DivisibilityArrayOfString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] expectedOne = { 1, 1, 0, 0, 0, 1, 1, 0, 0 };
		assert Arrays.equals(expectedOne, divisibilityArray("998244353", 3));

		final int[] expectedTwo = { 0, 1, 0, 1 };
		assert Arrays.equals(expectedTwo, divisibilityArray("1010", 10));
	}

	static int[] divisibilityArray(String word, int m) {
		final int n = word.length();
		final int[] d = new int[n];

		for (int i = 0, r = 0; i < n; i++) {
			final long v = r * 10l + (word.charAt(i) - ZERO);
			r = (int) (v % m);
			d[i] = r == 0 ? 1 : 0;
		}
		return d;
	}
}
