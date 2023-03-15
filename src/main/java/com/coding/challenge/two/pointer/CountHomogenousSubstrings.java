package com.coding.challenge.two.pointer;

class CountHomogenousSubstrings {
	private static final int MOD = 1000000007;

	CountHomogenousSubstrings() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert countHomogenous("abbcccaa") == 13;

		assert countHomogenous("xy") == 2;

		assert countHomogenous("zzzzz") == 15;
	}

	static int countHomogenous(String s) {
		final int n = s.length();
		int c = 0;
		for (int i = 0, j = 0; j < n; j++) {
			if (s.charAt(i) != s.charAt(j))
				i = j;
			c = (c + j - i + 1) % MOD;
		}
		return c;
	}
}
