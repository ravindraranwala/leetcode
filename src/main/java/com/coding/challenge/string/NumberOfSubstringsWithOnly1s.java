package com.coding.challenge.string;

class NumberOfSubstringsWithOnly1s {
	private static final int MOD = 1000000007;

	NumberOfSubstringsWithOnly1s() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert numSub("0110111") == 9;
		assert numSub("101") == 2;
		assert numSub("111111") == 21;
	}

	static int numSub(String s) {
		final int n = s.length();
		int c = 0;
		for (int i = 0, lastZeroIdx = -1; i < n; i++) {
			if (s.charAt(i) == '0')
				lastZeroIdx = i;

			c = (c + i - lastZeroIdx) % MOD;
		}
		return c;
	}
}
