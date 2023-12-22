package com.coding.challenge.dp;

class CoinChangeII {
	CoinChangeII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] coins1 = { 1, 2, 5 };
		assert change(5, coins1) == 4;

		final int[] coins2 = { 2 };
		assert change(3, coins2) == 0;

		final int[] coins3 = { 10 };
		assert change(10, coins3) == 1;
	}

	static int change(int amount, int[] coins) {
		final int m = coins.length;
		final int[][] c = new int[m + 1][amount + 1];
		for (int i = 1; i <= m; i++) {
			c[i][0] = 1;
			for (int j = 1; j <= amount; j++) {
				if (coins[i - 1] > j)
					c[i][j] = c[i - 1][j];
				else
					c[i][j] = c[i - 1][j] + c[i][j - coins[i - 1]];
			}
		}
		return c[m][amount];
	}
}
