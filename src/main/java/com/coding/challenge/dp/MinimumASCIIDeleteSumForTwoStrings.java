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
		// init.
		final int m = s1.length();
		final int n = s2.length();
		final int[][] t = new int[m + 1][n + 1];

		// trivial or base case of the recursion
		for (int i = 1; i <= m; i++)
			t[i][0] = t[i - 1][0] + s1.charAt(i - 1);

		for (int j = 1; j <= n; j++)
			t[0][j] = t[0][j - 1] + s2.charAt(j - 1);

		// non-trivial recursive step.
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					t[i][j] = t[i - 1][j - 1];
				else
					t[i][j] = Math.min(t[i - 1][j] + s1.charAt(i - 1), t[i][j - 1] + s2.charAt(j - 1));
			}
		}
		return t[m][n];
	}
}
