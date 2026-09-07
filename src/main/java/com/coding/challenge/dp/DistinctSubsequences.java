package com.coding.challenge.dp;

class DistinctSubsequences {
	DistinctSubsequences() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert numDistinct("rabbbit", "rabbit") == 3;
		assert numDistinct("babgbag", "bag") == 5;
	}

	static int numDistinct(String s, String t) {
		final int m = t.length();
		final int n = s.length();
		final int[][] ans = new int[m + 1][n + 1];
		// trivial case of the recursion
		for (int j = 0; j <= n; j++)
			ans[m][j] = 1;

		// Recursive step.
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (s.charAt(j) == t.charAt(i))
					ans[i][j] = ans[i][j + 1] + ans[i + 1][j + 1];
				else
					ans[i][j] = ans[i][j + 1];
			}
		}
		return ans[0][0];
	}
}
