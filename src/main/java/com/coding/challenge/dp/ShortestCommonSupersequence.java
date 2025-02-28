package com.coding.challenge.dp;

class ShortestCommonSupersequence {
	ShortestCommonSupersequence() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "cabac".equals(shortestCommonSupersequence("abac", "cab"));
	}

	static String shortestCommonSupersequence(String str1, String str2) {
		final int m = str1.length();
		final int n = str2.length();
		final int[][] l = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1))
					l[i][j] = l[i - 1][j - 1] + 1;
				else
					l[i][j] = Math.max(l[i - 1][j], l[i][j - 1]);
			}
		}

		final StringBuilder ans = new StringBuilder();
		int i = m;
		int j = n;
		while (i > 0 && j > 0) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				ans.append(str1.charAt(i - 1));
				i = i - 1;
				j = j - 1;
			} else if (l[i - 1][j] > l[i][j - 1]) {
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
}
