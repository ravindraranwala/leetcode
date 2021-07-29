package com.coding.challenge.dp;

class LongestPalindromicSubstring {
	LongestPalindromicSubstring() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String s = "aaaa";
		final String p = longestPalindrome(s);
		System.out.println(p);
	}

	public static String longestPalindrome(String s) {
		if (s.isEmpty())
			return s;

		final int n = s.length();
		final boolean[][] p = new boolean[n][n];
		for (int i = 0; i < n; i++)
			p[i][i] = true;

		int l = 1;
		int start = 0;
		for (int len = 2; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i++) {
				final int j = i + len - 1;
				if (s.charAt(i) == s.charAt(j) && (len == 2 || p[i + 1][j - 1])) {
					p[i][j] = true;
					start = i;
					l = len;
				} else
					p[i][j] = false;
			}
		}
		return s.substring(start, start + l);
	}
}