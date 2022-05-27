package com.coding.challenge.dp;

class MinDifficultyJobSchedule {
	MinDifficultyJobSchedule() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] jd1 = { 6, 5, 4, 3, 2, 1 };
		final int d1 = 2;
		int md = minDifficulty(jd1, d1);
		assert md == 7;

		md = minDifficulty(jd1, 3);
		assert md == 9;

		final int[] jd2 = { 9, 9, 9 };
		final int d2 = 4;
		md = minDifficulty(jd2, d2);
		assert md == -1;

		final int[] jd3 = { 1, 1, 1 };
		final int d3 = 3;
		md = minDifficulty(jd3, d3);
		assert md == 3;

		final int[] jd4 = { 11, 111, 22, 222, 33, 333, 44, 444 };
		final int d4 = 6;
		md = minDifficulty(jd4, d4);
		assert md == 843;
	}

	static int minDifficulty(int[] jobDifficulty, int d) {
		final int n = jobDifficulty.length;
		if (d > n)
			return -1;

		final int[][] md = new int[d + 1][n + 1];

		// trivial case of the recursion
		md[1][1] = jobDifficulty[0];
		for (int i = 2; i <= n; i++)
			md[1][i] = Math.max(md[1][i - 1], jobDifficulty[i - 1]);

		// non-trivial case of the recursion
		for (int i = 2; i <= d; i++) {
			for (int j = i; j <= n; j++) {
				md[i][j] = Integer.MAX_VALUE;
				int jd = Integer.MIN_VALUE;
				for (int k = j - 1; k >= i - 1; k--) {
					jd = Math.max(jd, jobDifficulty[k]);
					md[i][j] = Math.min(md[i][j], md[i - 1][k] + jd);
				}
			}
		}

		return md[d][n];
	}
}
