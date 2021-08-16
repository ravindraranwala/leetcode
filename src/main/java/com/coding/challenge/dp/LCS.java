package com.coding.challenge.dp;

class LCS {
	LCS() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String text1 = "abcde";
		final String text2 = "ace";
		final int l = lcsLength(text1, text2);
		System.out.println(String.format("The length of the longest common subsequence is: %d", l));
	}

	private static int lcsLength(String text1, String text2) {
		final int m = text1.length();
		final int n = text2.length();
		final int[][] c = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++)
			c[i][0] = 0;
		for (int j = 0; j <= n; j++)
			c[0][j] = 0;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1))
					c[i][j] = c[i - 1][j - 1] + 1;
				else if (c[i - 1][j] >= c[i][j - 1])
					c[i][j] = c[i - 1][j];
				else
					c[i][j] = c[i][j - 1];
			}
		}
		return c[m][n];
	}
}
