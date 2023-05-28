package com.coding.challenge.dp;

class TotalAppealOfString {
	private static final char a = 'a';

	TotalAppealOfString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String strOne = "abbca";
		assert appealSum(strOne) == 28;

		final String strTwo = "code";
		assert appealSum(strTwo) == 20;
	}

	static long appealSum(String s) {
		final int n = s.length();
		final int[] p = new int[26];
		long ans = 0;
		long prevAns = 0;

		for (int i = 1; i <= n; i++) {
			final char ch = s.charAt(i - 1);
			final int j = p[ch - a];
			final long currAns = prevAns + i - j;
			p[ch - a] = i;
			ans = ans + currAns;
			prevAns = currAns;
		}
		return ans;
	}
}
