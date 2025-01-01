package com.coding.challenge.dp;

class CountWaysToBuildGoodStrings {
	private static final int MOD = 1000000007;

	CountWaysToBuildGoodStrings() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert countGoodStrings(3, 3, 1, 1) == 8;
		assert countGoodStrings(2, 3, 1, 2) == 5;
	}

	static int countGoodStrings(int low, int high, int zero, int one) {
		final int[] s = new int[high + 1];
		s[0] = 1;

		for (int i = 0; i <= high; i++) {
			if (i >= zero)
				s[i] = s[i - zero];
			if (i >= one)
				s[i] = (s[i] + s[i - one]) % MOD;
		}
		// constructing an optimal solution
		int c = 0;
		for (int j = low; j <= high; j++)
			c = (c + s[j]) % MOD;

		return c;
	}
}
