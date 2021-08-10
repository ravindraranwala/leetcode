package com.coding.challenge.dp;

class LongestPalindromeSubsequence {

	LongestPalindromeSubsequence() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String s = "character";
		final int[][] p = longestPalindromeSubsequence(s);
		System.out.println(String.format("Length of the longest palindrome subsequence is: %d", p[0][s.length() - 1]));
		final String lp = constructLongestPalindromeSubsequence(p, s);
		System.out.println("One possible longest palindromic subsequence is: " + lp);
	}

	static int[][] longestPalindromeSubsequence(String s) {
		final int n = s.length();
		final int[][] p = new int[n][n];
		for (int i = 0; i < n; i++)
			p[i][i] = 1;
		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				final int j = i + l - 1;
				if (s.charAt(i) == s.charAt(j))
					p[i][j] = p[i + 1][j - 1] + 2;
				else
					p[i][j] = Math.max(p[i][j - 1], p[i + 1][j]);
			}
		}
		return p;
	}

	static String constructLongestPalindromeSubsequence(int[][] p, String s) {
		int idx = 0;
		int i = 0;
		int j = s.length() - 1;
		final int n = p[i][j];
		final char[] c = new char[n];
		while (j > i) {
			if (s.charAt(i) == s.charAt(j)) {
				c[idx] = s.charAt(i);
				c[n - idx - 1] = s.charAt(i);
				i = i + 1;
				j = j - 1;
				idx = idx + 1;
			} else if (p[i][j] == p[i][j - 1])
				j = j - 1;
			else
				i = i + 1;
		}
		if (i == j)
			c[idx] = s.charAt(i);
		return new String(c);
	}
}
