package com.coding.challenge.greedy;

class LargestIntegerWithGivenDigitSum {
	private static final int MAX_DIGIT = 9;
	private static final int DEFAULT_ANS = -1;

	LargestIntegerWithGivenDigitSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert largestInteger(2, 9) == 90;
		assert largestInteger(2, 19) == -1;
		assert largestInteger(5, 0) == 0;
	}

	static int largestInteger(int n, int s) {
		int ans = 0;
		int digitSum = 0;
		for (int digits = 0; digits < n; digits++) {
			final int currDigit = Math.min(MAX_DIGIT, s - digitSum);
			ans = ans * 10 + currDigit;
			digitSum = digitSum + currDigit;
		}

		if (digitSum == s)
			return ans;

		return DEFAULT_ANS;
	}
}
