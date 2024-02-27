package com.coding.challenge.dp;

class PalindromicSubstrings {
	PalindromicSubstrings() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert countSubstrings("abc") == 3;
		assert countSubstrings("aaa") == 6;
	}

	static int countSubstrings(String s) {
		final int n = s.length();
		final boolean[][] p = new boolean[n][n];
		int c = n;
		// trivial case of the recursion.
		for (int i = 0; i < n; i++)
			p[i][i] = true;

		for (int i = 0; i < n - 1; i++) {
			p[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
			if (p[i][i + 1])
				c = c + 1;
		}

		for (int l = 3; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				final int j = i + l - 1;
				p[i][j] = s.charAt(i) == s.charAt(j) && p[i + 1][j - 1];
				if (p[i][j])
					c = c + 1;
			}
		}
		return c;
	}
}
