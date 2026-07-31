package com.coding.challenge.math;

class MinimumNumberOfPushesToTypeWordI {
	private static final int NUM_OF_KEYS = 8;

	MinimumNumberOfPushesToTypeWordI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minimumPushes("abcde") == 5;
		assert minimumPushes("xycdefghij") == 12;
	}

	static int minimumPushes(String word) {
		final int n = word.length();
		if (n <= NUM_OF_KEYS)
			return n;
		else if (n <= 2 * NUM_OF_KEYS)
			return NUM_OF_KEYS + 2 * (n - NUM_OF_KEYS);
		else if (n <= 3 * NUM_OF_KEYS)
			return 3 * NUM_OF_KEYS + 3 * (n - 2 * NUM_OF_KEYS);
		else
			return 6 * NUM_OF_KEYS + 4 * (n - 3 * NUM_OF_KEYS);
	}
}
