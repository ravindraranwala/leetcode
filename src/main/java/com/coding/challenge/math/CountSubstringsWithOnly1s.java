package com.coding.challenge.math;

class CountSubstringsWithOnly1s {
	private static final int MOD = 1000000007;
	private static final char ONE = '1';
	
	CountSubstringsWithOnly1s() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert numSub("0110111") == 9;
		assert numSub("101") == 2;
		assert numSub("111111") == 21;
	}

	static int numSub(String s) {
		final int n = s.length();
		int cnt = 0;
		for (int i = 0, continuousOnes = 0; i < n; i++) {
			continuousOnes = s.charAt(i) == ONE ? continuousOnes + 1 : 0;
			cnt = (cnt + continuousOnes) % MOD;
		}
		return cnt;
	}
}
