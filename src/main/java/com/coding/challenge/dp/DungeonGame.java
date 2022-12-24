package com.coding.challenge.dp;

class DungeonGame {
	DungeonGame() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] dungeonOne = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		int minHp = calculateMinimumHP(dungeonOne);
		System.out.println(minHp);

		final int[][] dungeonTwo = { { 0 } };
		minHp = calculateMinimumHP(dungeonTwo);
		System.out.println(minHp);

		final int[][] dungeonThree = { { 1, -3, 3 }, { 0, -2, 0 }, { -3, -3, -3 } };
		minHp = calculateMinimumHP(dungeonThree);
		System.out.println(minHp);
	}

	static int calculateMinimumHP(int[][] dungeon) {
		final int m = dungeon.length;
		final int n = dungeon[0].length;
		final int[][] minHealthPoints = new int[m][n];

		// trivial case of the recursion.
		minHealthPoints[m - 1][n - 1] = dungeon[m - 1][n - 1];

		for (int i = m - 2; i >= 0; i--)
			minHealthPoints[i][n - 1] = Math.min(dungeon[i][n - 1], minHealthPoints[i + 1][n - 1] + dungeon[i][n - 1]);

		for (int j = n - 2; j >= 0; j--)
			minHealthPoints[m - 1][j] = Math.min(dungeon[m - 1][j], minHealthPoints[m - 1][j + 1] + dungeon[m - 1][j]);

		// recursive step.
		for (int i = m - 2; i >= 0; i--)
			for (int j = n - 2; j >= 0; j--)
				minHealthPoints[i][j] = Math.min(dungeon[i][j],
						Math.max(minHealthPoints[i + 1][j], minHealthPoints[i][j + 1]) + dungeon[i][j]);

		return minHealthPoints[0][0] > 0 ? 1 : Math.abs(minHealthPoints[0][0]) + 1;
	}
}
