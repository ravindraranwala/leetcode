package com.coding.challenge.dp;

class MinimumDeletionsToMakeStringBalanced {
	MinimumDeletionsToMakeStringBalanced() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minimumDeletions("aababbab") == 2;
		assert minimumDeletions("bbaaaaabb") == 2;
	}

	static int minimumDeletions(String s) {
		final int n = s.length();
		int d = 0;
		for (int i = 0, bCnt = 0; i < n; i++) {
			if (s.charAt(i) == 'a')
				// two choices here.
				// If s[i] is chosen or it is not chosen.
				d = Math.min(bCnt, d + 1);
			else
				bCnt = bCnt + 1;
		}
		return d;
	}
}
