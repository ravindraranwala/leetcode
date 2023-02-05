package com.coding.challenge.dp;

class DistinctSubsequences {
	DistinctSubsequences() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String s1 = "rabbbit";
		final String t1 = "rabbit";
		assert numDistinct(s1, t1) == 3;

		final String s2 = "babgbag";
		final String t2 = "bag";
		assert numDistinct(s2, t2) == 5;
	}

	static int numDistinct(String s, String t) {
		final int m = t.length();
		final int n = s.length();
		final int[][] c = new int[m][n + 1];

		// trivial case of the recursion.
		for (int j = 0; j < n; j++)
			c[0][j + 1] = s.charAt(j) == t.charAt(0) ? c[0][j] + 1 : c[0][j];

		// recursive step
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (t.charAt(i) == s.charAt(j))
					c[i][j + 1] = c[i - 1][j] + c[i][j];
				else
					c[i][j + 1] = c[i][j];
			}
		}
		return c[m - 1][n];
	}
}
