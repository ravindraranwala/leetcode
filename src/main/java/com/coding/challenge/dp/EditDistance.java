package com.coding.challenge.dp;

public class EditDistance {

	public static void main(String[] args) {
		String x = "intention";
		String y = "execution";
		System.out.println(String.format("Min Edit Distance: %d", editDistance(x, y)));
	}

	private static int editDistance(String x, String y) {
		final int m = x.length();
		final int n = y.length();
		final int[][] c = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++)
			c[i][0] = i;
		for (int j = 0; j <= n; j++)
			c[0][j] = j;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				// Copy task
				if (x.charAt(i - 1) == y.charAt(j - 1))
					c[i][j] = c[i - 1][j - 1];
				else
					// Replace, Insert and Delete tasks are considered here.
					c[i][j] = Math.min(Math.min(c[i - 1][j], c[i][j - 1]), c[i - 1][j - 1]) + 1;
			}
		}
		return c[m][n];
	}

	private static int editDistanceTwoRows(String x, String y) {
		final int m = x.length();
		final int n = y.length();
		final int[][] c = new int[2][n + 1];

		for (int j = 0; j <= n; j++)
			c[0][j] = j;

		for (int i = 1; i <= m; i++) {
			final int newI = i % 2;
			c[newI][0] = i;
			final int prevI = newI % 2 == 0 ? newI + 1 : newI - 1;
			for (int j = 1; j <= n; j++) {
				// Copy task
				if (x.charAt(i - 1) == y.charAt(j - 1))
					c[newI][j] = c[prevI][j - 1];
				else
					// Replace, Insert and Delete tasks are considered here.
					c[newI][j] = Math.min(Math.min(c[prevI][j], c[newI][j - 1]), c[prevI][j - 1]) + 1;
			}
		}
		return c[m % 2][n];
	}
}
