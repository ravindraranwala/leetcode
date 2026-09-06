package com.coding.challenge.dp;

class DistinctSubsequences {
	DistinctSubsequences() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert numDistinct("rabbbit", "rabbit") == 3;
		assert numDistinct("babgbag", "bag") == 5;
	}

	static int numDistinct(String s, String t) {
		final int m = t.length();
		final int n = s.length();
		final int[] ans = new int[n];
		// trivial case of the recursion where i = m - 1.
		for (int j = 0; j < n; j++)
			if (s.charAt(j) == t.charAt(m - 1))
				ans[j] = 1;

		// recursive step.
		for (int i = m - 2; i >= 0; i--) {
			final int[] c = new int[n];
			// Postfix sum of smaller subinstance solutions.
			int postfixSum = 0;
			for (int k = n - 1; k >= 0; k--) {
				postfixSum = postfixSum + ans[k];
				c[k] = postfixSum;
			}

			final int l = m - i;
			for (int j = 0; j < n; j++) {
				if (j <= n - l) {
					if (s.charAt(j) == t.charAt(i))
						ans[j] = c[j + 1];
					else
						ans[j] = 0;
				} else {
					// no solution exists as s is shorter than t.
					ans[j] = 0;
				}
			}
		}

		int cnt = 0;
		for (int idx = 0; idx < n; idx++)
			cnt = cnt + ans[idx];

		return cnt;
	}
}
