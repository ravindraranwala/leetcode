package com.coding.challenge.dp;

class MinInsertionsToMakePalindrome {
	MinInsertionsToMakePalindrome() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String s1 = "zzazz";
		int minIns = minInsertions(s1);
		assert minIns == 0;

		final String s2 = "mbadm";
		minIns = minInsertions(s2);
		assert minIns == 2;

		final String s3 = "leetcode";
		minIns = minInsertions(s3);
		assert minIns == 5;

		final String s4 = "ab";
		minIns = minInsertions(s4);
		assert minIns == 1;
	}

	static int minInsertions(String s) {
		final int n = s.length();
		final int[][] p = new int[n][n];
		// set the diagonal entries first
		for (int i = 0; i < n; i++)
			p[i][i] = 1;
		// solve the subproblems of size 2
		for (int j = 0; j < n - 1; j++)
			p[j][j + 1] = s.charAt(j) == s.charAt(j + 1) ? 2 : 1;

		for (int l = 3; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				final int j = i + l - 1;
				if (s.charAt(i) == s.charAt(j))
					p[i][j] = p[i + 1][j - 1] + 2;
				else
					p[i][j] = Math.max(p[i][j - 1], p[i + 1][j]);
			}
		}
		return n - p[0][n - 1];
	}
}
