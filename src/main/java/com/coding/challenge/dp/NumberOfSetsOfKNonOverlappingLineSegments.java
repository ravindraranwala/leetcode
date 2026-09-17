package com.coding.challenge.dp;

class NumberOfSetsOfKNonOverlappingLineSegments {
	private static final int MOD = 1000000007;

	NumberOfSetsOfKNonOverlappingLineSegments() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert numberOfSets(3, 1) == 3;
		assert numberOfSets(4, 1) == 6;
		assert numberOfSets(4, 2) == 5;
		assert numberOfSets(30, 7) == 796297179;
	}

	static int numberOfSets(int n, int k) {
		final int[][] c = new int[k + 1][n];
		// Trivial case of the recursion.
		for (int i = 0; i < n; i++)
			c[1][i] = n - 1 - i;

		for (int lines = 2; lines <= k; lines++) {
			for (int i = n - 2, s = 0; i >= 0; i--) {
				c[lines][i] = (c[lines][i + 1] + s) % MOD;
				s = (s + c[lines - 1][i]) % MOD;
			}
		}

		// constructing an optimal solution.
		int ans = 0;
		for (int i = 0; i < n; i++)
			ans = (ans + c[k][i]) % MOD;

		return ans;
	}
}
