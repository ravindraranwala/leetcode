package com.coding.challenge.dp;

class LongestPalindromicSubstring {
	LongestPalindromicSubstring() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String s = "babadbabad";
		final String p = longestPalindrome(s);
		System.out.println(p);
	}

	public static String longestPalindrome(String s) {
		final int n = s.length();
		final boolean[][] p = new boolean[n][n];
		int l = 1;
		int start = 0;
		for (int i = 0; i < n; i++)
			p[i][i] = true;
		for (int i = 0; i < n - 1; i++) {
			p[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
			if (p[i][i + 1]) {
				l = 2;
				start = i;
			}
		}
		for (int len = 3; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i++) {
				final int j = i + len - 1;
				p[i][j] = s.charAt(i) == s.charAt(j) && p[i + 1][j - 1];
				if (p[i][j]) {
					start = i;
					l = len;
				}
			}
		}
		return s.substring(start, start + l);
	}
}