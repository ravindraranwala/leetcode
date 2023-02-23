package com.coding.challenge.dp;

class MinimumCostTreeFromLeafValues {
	MinimumCostTreeFromLeafValues() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] treeOne = { 6, 2, 4 };
		assert mctFromLeafValues(treeOne) == 32;

		final int[] treeTwo = { 4, 11 };
		assert mctFromLeafValues(treeTwo) == 44;
		

		final int[] treeThree = { 5, 4, 1, 3, 2 };
		assert mctFromLeafValues(treeThree) == 41;

		final int[] treeFour = { 1, 2, 3, 4, 5 };
		assert mctFromLeafValues(treeFour) == 40;

		final int[] treeFive = { 15, 13, 5, 3, 15 };
		assert mctFromLeafValues(treeFive) == 500;
	}

	static int mctFromLeafValues(int[] arr) {
		final int n = arr.length;
		final int[][] cost = new int[n][n];
		final int[][] max = new int[n][n];

		// trivial case of the recursion.
		for (int i = 0; i < n; i++)
			max[i][i] = arr[i];

		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				final int j = i + l - 1;
				cost[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++)
					cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k + 1][j] + max[i][k] * max[k + 1][j]);

				max[i][j] = Math.max(max[i][j - 1], arr[j]);
			}
		}

		return cost[0][n - 1];
	}
}
