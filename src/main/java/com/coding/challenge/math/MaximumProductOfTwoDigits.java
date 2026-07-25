package com.coding.challenge.math;

class MaximumProductOfTwoDigits {
	MaximumProductOfTwoDigits() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maxProduct(31) == 3;
		assert maxProduct(22) == 4;
		assert maxProduct(124) == 8;
	}

	static int maxProduct(int n) {
		int largestDigit = 0;
		int secondLargestDigit = 0;
		for (int curr = n; curr > 0; curr = curr / 10) {
			final int digit = curr % 10;
			if (digit > largestDigit) {
				secondLargestDigit = largestDigit;
				largestDigit = digit;
			} else if (digit > secondLargestDigit) {
				secondLargestDigit = digit;
			}
		}
		return largestDigit * secondLargestDigit;
	}
}
