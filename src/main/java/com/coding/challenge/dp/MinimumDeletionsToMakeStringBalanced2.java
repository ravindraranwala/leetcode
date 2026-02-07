package com.coding.challenge.dp;

class MinimumDeletionsToMakeStringBalanced2 {
	MinimumDeletionsToMakeStringBalanced2() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minimumDeletions("aababbab") == 2;
		assert minimumDeletions("bbaaaaabb") == 2;
	}

	static int minimumDeletions(String s) {
		final int n = s.length();
		int l = 0;
		for (int i = 0, bCnt = 0; i < n; i++) {
			if (s.charAt(i) == 'a')
				l = Math.max(i + 1 - bCnt, l);
			else {
				bCnt = bCnt + 1;
				l = l + 1;
			}
		}
		return n - l;
	}
}
