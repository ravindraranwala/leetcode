package com.coding.challenge.greedy;

class MinimumNumberOfChangesToMakeBinaryStringBeautiful {
	private static final char ZERO = '0';

	MinimumNumberOfChangesToMakeBinaryStringBeautiful() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minChanges("1001") == 2;
		assert minChanges("10") == 1;
		assert minChanges("0000") == 0;
		assert minChanges("001011001111100001") == 3;
	}

	// Sub-optimal dynamic programming solution.
	static int minChangesDp(String s) {
		final int n = s.length();
		final int[] c = new int[n];

		for (int i = 1; i < n; i = i + 2) {
			c[i] = Integer.MAX_VALUE;
			for (int k = i, zeros = 0; k >= 0; k--) {
				if (s.charAt(k) == ZERO) {
					zeros = zeros + 1;
				}
				if ((i - k + 1) % 2 == 0) {
					if (k == 0) {
						c[i] = Math.min(c[i], Math.min(zeros, i + 1 - zeros));
					} else {
						c[i] = Math.min(c[i], c[k - 1] + Math.min(zeros, i - k + 1 - zeros));
					}
				}
			}
		}
		return c[n - 1];
	}

	static int minChanges(String s) {
		final int n = s.length();
		int changes = 0;
		for (int i = 0; i < n; i = i + 2) {
			if (s.charAt(i) != s.charAt(i + 1))
				changes = changes + 1;
		}
		return changes;
	}
}
