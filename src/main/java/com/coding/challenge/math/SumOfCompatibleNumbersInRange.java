package com.coding.challenge.math;

class SumOfCompatibleNumbersInRange {
	SumOfCompatibleNumbersInRange() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert sumOfGoodIntegers(2, 3) == 10;
		assert sumOfGoodIntegers(5, 1) == 0;
		assert sumOfGoodIntegers(1, 13) == 56;
	}

	static int sumOfGoodIntegers(int n, int k) {
		int sum = 0;
		for (int x = Math.max(n - k, 1); x <= n + k; x++)
			if ((x & n) == 0)
				sum = sum + x;

		return sum;
	}
}
