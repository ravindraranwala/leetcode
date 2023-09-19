package com.coding.challenge.math;

import java.util.Arrays;

class FindThreeConsecutiveIntegersThatSumToTarget {
	FindThreeConsecutiveIntegersThatSumToTarget() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert Arrays.equals(new long[] { 10, 11, 12 }, sumOfThree(33));

		assert Arrays.equals(new long[0], sumOfThree(4));

		assert Arrays.equals(new long[] { -1, 0, 1 }, sumOfThree(0));
	}

	static long[] sumOfThree(long num) {
		if (num % 3 == 0) {
			final long mid = num / 3;
			return new long[] { mid - 1, mid, mid + 1 };
		} else
			return new long[0];
	}
}
