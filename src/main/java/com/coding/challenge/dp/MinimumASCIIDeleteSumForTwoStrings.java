package com.coding.challenge.dp;

class MinimumASCIIDeleteSumForTwoStrings {
	MinimumASCIIDeleteSumForTwoStrings() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minimumDeleteSum("sea", "eat") == 231;

		assert minimumDeleteSum("delete", "leet") == 403;
	}

	static int minimumDeleteSum(String s1, String s2) {
		final int m = s1.length();
		final int n = s2.length();
		final int[][] c = new int[m + 1][n + 1];
		// trivial case of the recursion.
		c[0][0] = 0;
		for (int i = 1; i <= m; i++)
			c[i][0] = c[i - 1][0] + s1.charAt(i - 1);

		for (int j = 1; j <= n; j++)
			c[0][j] = c[0][j - 1] + s2.charAt(j - 1);

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					c[i][j] = c[i - 1][j - 1];
				else
					c[i][j] = Math.min(c[i][j - 1] + s2.charAt(j - 1), c[i - 1][j] + s1.charAt(i - 1));
			}
		}

		return c[m][n];
	}
}
