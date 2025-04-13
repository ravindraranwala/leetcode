package com.coding.challenge.recursion;

class CountGoodNumbers {
	private static final int REM = 1000000007;

	CountGoodNumbers() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert countGoodNumbers(1) == 5;
		assert countGoodNumbers(4) == 400;
		assert countGoodNumbers(50) == 564908303;
	}

	static int countGoodNumbers(long n) {
		if (n == 1)
			return 5;
		final int c = fastExponentiation(n / 2);
		if (n % 2 == 0)
			return c;
		return (int) ((c * 5l) % REM);
	}

	private static int fastExponentiation(long n) {
		if (n == 1)
			return 20;

		if (n % 2 == 0) {
			final int ans = fastExponentiation(n / 2);
			return (int) ((ans * 1l * ans) % REM);
		}

		return (int) ((fastExponentiation(n - 1) * 20l) % REM);
	}
}
