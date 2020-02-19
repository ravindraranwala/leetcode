package com.coding.challenge;

public final class LongestPaliandromicSubstr {

	public static void main(String[] args) {
		final String input = "babadada";
		String p = longestPalindrome(input);
		System.out.println(p);
	}

	public static String longestPalindrome(String s) {
		if (s.isEmpty())
			return "";

		final int n = s.length();
		final int[][] length = new int[n][n];
		final int[][] start = new int[n][n];
		for (int i = 0; i < n; i++) {
			length[i][i] = 1;
			start[i][i] = i;
		}

		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				final int j = i + l - 1;
				if (s.charAt(i) == s.charAt(j)
						&& (l == 2 || (start[i + 1][j - 1] == i + 1 && length[i + 1][j - 1] == j - i - 1))) {
					start[i][j] = i;
					length[i][j] = length[i + 1][j - 1] + 2;
				} else {
					if (length[i][j - 1] >= length[i + 1][j]) {
						length[i][j] = length[i][j - 1];
						start[i][j] = start[i][j - 1];
					} else {
						length[i][j] = length[i + 1][j];
						start[i][j] = start[i + 1][j];
					}
				}
			}
		}
		final int palindStart = start[0][n - 1];
		return s.substring(palindStart, palindStart + length[0][n - 1]);
	}
}
