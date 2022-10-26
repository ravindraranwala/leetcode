package com.coding.challenge.dp;

class CoinChange {
	CoinChange() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] coinsOne = { 1, 2, 5 };
		assert coinChange(coinsOne, 11) == 3;

		final int[] coinsTwo = { 2 };
		assert coinChange(coinsTwo, 3) == -1;

		final int[] coinsThree = { 1 };
		assert coinChange(coinsThree, 0) == 0;
	}

	static int coinChange(int[] coins, int amount) {
		final int n = coins.length;
		final int[][] t = new int[n + 1][amount + 1];

		// trivial case of the recursion
		for (int i = 0; i <= n; i++)
			t[i][0] = 0;

		for (int j = 1; j <= amount; j++)
			t[0][j] = (int) 1e+5;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= amount; j++) {
				if (coins[i - 1] <= j)
					t[i][j] = Math.min(t[i][j - coins[i - 1]] + 1, t[i - 1][j]);
				else
					t[i][j] = t[i - 1][j];
			}
		}
		return t[n][amount] < 1e+5 ? t[n][amount] : -1;
	}
}
