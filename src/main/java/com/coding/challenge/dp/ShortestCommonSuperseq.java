package com.coding.challenge.dp;

class ShortestCommonSuperseq {
	ShortestCommonSuperseq() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		String superSeq = shortestCommonSupersequence("abac", "cab");
		assert superSeq.equals("cabac");

		superSeq = shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa");
		assert superSeq.equals("aaaaaaaa");
		
		superSeq = shortestCommonSupersequence("ABCBDAB", "BDCABA");
		assert superSeq.equals("ABDCABDAB");
	}

	static String shortestCommonSupersequence(String str1, String str2) {
		final int[][] c = lcs(str1, str2);
		int i = str1.length();
		int j = str2.length();
		final StringBuilder ans = new StringBuilder();

		while (i > 0 && j > 0) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				ans.append(str1.charAt(i - 1));
				i = i - 1;
				j = j - 1;
			} else if (c[i - 1][j] >= c[i][j - 1]) {
				ans.append(str1.charAt(i - 1));
				i = i - 1;
			} else {
				ans.append(str2.charAt(j - 1));
				j = j - 1;
			}
		}

		while (i > 0) {
			ans.append(str1.charAt(i - 1));
			i = i - 1;
		}

		while (j > 0) {
			ans.append(str2.charAt(j - 1));
			j = j - 1;
		}

		return ans.reverse().toString();
	}

	static int[][] lcs(String text1, String text2) {
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
		return c;
	}
}
