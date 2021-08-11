package com.coding.challenge.dp;

class LongestPalindromeSubsequence {

	LongestPalindromeSubsequence() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String s = "character";
		final int[][] p = longestPalindromeSubsequence(s);
		System.out.println(String.format("Length of the longest palindrome subsequence is: %d", p[0][s.length() - 1]));
		final StringBuilder sb = new StringBuilder();
		constructLongestPalindromeSubsequence(p, s, 0, s.length() - 1, sb);
		System.out.println("One possible longest palindromic subsequence is: " + sb.toString());
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

	static void constructLongestPalindromeSubsequence(int[][] p, String s, int i, int j, StringBuilder sb) {
		if (i == j)
			sb.append(s.charAt(i));
		while (j > i && s.charAt(i) != s.charAt(j)) {
			if (p[i][j] == p[i][j - 1])
				j = j - 1;
			else
				i = i + 1;
		}
		if (j > i && s.charAt(i) == s.charAt(j)) {
			sb.append(s.charAt(i));
			constructLongestPalindromeSubsequence(p, s, i + 1, j - 1, sb);
			sb.append(s.charAt(j));
		}
	}
}
