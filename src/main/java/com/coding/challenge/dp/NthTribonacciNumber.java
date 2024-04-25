package com.coding.challenge.dp;

class NthTribonacciNumber {
	NthTribonacciNumber() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert tribonacci(4) == 4;
		assert tribonacci(25) == 1389537;
	}

	static int tribonacci(int n) {
		if (n == 1 || n == 2)
			return 1;
		int tn = 0;

		for (int i = 3, tribThreeBefore = 0, tribTwoBefore = 1, tribOneBefore = 1; i <= n; i++) {
			tn = tribThreeBefore + tribTwoBefore + tribOneBefore;
			tribThreeBefore = tribTwoBefore;
			tribTwoBefore = tribOneBefore;
			tribOneBefore = tn;
		}
		return tn;
	}
}
