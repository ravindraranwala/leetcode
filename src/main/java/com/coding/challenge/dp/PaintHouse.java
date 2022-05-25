package com.coding.challenge.dp;

class PaintHouse {
	PaintHouse() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] houses1 = { 0, 0, 0, 0, 0 };
		final int[][] cost1 = { { 1, 10 }, { 10, 1 }, { 10, 1 }, { 1, 10 }, { 5, 1 } };
		int pc = minCost(houses1, cost1, 3);
		assert pc == 9;

		final int[] houses2 = { 0, 2, 1, 2, 0 };
		final int[][] cost2 = { { 1, 10 }, { 10, 1 }, { 10, 1 }, { 1, 10 }, { 5, 1 } };
		pc = minCost(houses2, cost2, 3);
		assert pc == 11;

		final int[] houses3 = { 3, 1, 2, 3 };
		final int[][] cost3 = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		pc = minCost(houses3, cost3, 3);
		assert pc == -1;
		
		final int[] houses4 = { 1 };
		final int[][] cost4 = { { 15, 10 } };
		pc = minCost(houses4, cost4, 1);
		assert pc == 0;
		
		final int[] houses5 = { 0 };
		final int[][] cost5 = { { 15, 10 } };
		pc = minCost(houses5, cost5, 1);
		assert pc == 10;
	}

	static int minCost(int[] houses, int[][] cost, int target) {
		final int m = houses.length;
		final int n = cost[0].length;
		final int[][][] p = new int[m + 1][target + 1][n + 1];

		for (int i = 0; i < n; i++)
			p[0][0][i] = 0;
		for (int j = 1; j <= target; j++)
			for (int k = 0; k < n; k++)
				p[0][j][k] = -1;
		for (int i = 1; i <= m; i++)
			for (int k = 0; k < n; k++)
				p[i][0][k] = -1;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= target; j++) {
				for (int k = 0; k < n; k++) {
					if (j > i)
						p[i][j][k] = -1;
					else if (houses[i - 1] != 0 && houses[i - 1] != k + 1)
						p[i][j][k] = -1;
					else {
						int ans = Integer.MAX_VALUE;
						for (int l = 0; l < n; l++)
							if (l != k && p[i - 1][j - 1][l] != -1)
								ans = Math.min(ans, p[i - 1][j - 1][l]);
						if (p[i - 1][j][k] != -1)
							ans = Math.min(ans, p[i - 1][j][k]);

						if (houses[i - 1] == 0 && ans != Integer.MAX_VALUE)
							ans = ans + cost[i - 1][k];
						p[i][j][k] = ans == Integer.MAX_VALUE ? -1 : ans;
					}

				}
			}
		}

		int r = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++)
			if (p[m][target][i] != -1)
				r = Math.min(r, p[m][target][i]);
		return r == Integer.MAX_VALUE ? -1 : r;
	}
}
