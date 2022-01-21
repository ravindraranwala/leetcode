package com.coding.challenge.dp;

class MinDifficultyJobSchedule {
	MinDifficultyJobSchedule() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] jd1 = { 6, 5, 4, 3, 2, 1 };
		final int d1 = 2;
		int md = minDifficulty(jd1, d1);
		System.out.println(md);

		md = minDifficulty(jd1, 3);
		System.out.println(md);

		final int[] jd2 = { 9, 9, 9 };
		final int d2 = 4;
		md = minDifficulty(jd2, d2);
		System.out.println(md);

		final int[] jd3 = { 1, 1, 1 };
		final int d3 = 3;
		md = minDifficulty(jd3, d3);
		System.out.println(md);
	}

	static int minDifficulty(int[] jobDifficulty, int d) {
		final int n = jobDifficulty.length;
		if (d > n)
			return -1;
		final int[][] md = new int[d + 1][n];
		// trivial case of our recursion.
		md[1][n - 1] = jobDifficulty[n - 1];
		for (int j = n - 2; j >= 0; j--)
			md[1][j] = Math.max(jobDifficulty[j], md[1][j + 1]);

		// Non-trivial case of the recursion.
		for (int i = 2; i <= d; i++) {
			for (int j = 0; j < n; j++) {
				int mx = jobDifficulty[j];
				md[i][j] = Integer.MAX_VALUE;
				// splitting at every possible k
				for (int k = j; k < n - i + 1; k++) {
					mx = Math.max(mx, jobDifficulty[k]);
					if (md[i][j] > mx + md[i - 1][k + 1])
						md[i][j] = mx + md[i - 1][k + 1];
				}
			}
		}
		return md[d][0];
	}
}
