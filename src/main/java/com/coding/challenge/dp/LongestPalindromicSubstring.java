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
		for (int i = 1; i < n; i++) {
			p[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
			if (p[i - 1][i]) {
				l = 2;
				start = i - 1;
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