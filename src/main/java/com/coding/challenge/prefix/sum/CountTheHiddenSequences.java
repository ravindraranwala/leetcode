package com.coding.challenge.prefix.sum;

class CountTheHiddenSequences {
	CountTheHiddenSequences() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] differences1 = { 1, -3, 4 };
		assert numberOfArrays(differences1, 1, 6) == 2;

		final int[] differences2 = { 3, -4, 5, 1, -2 };
		assert numberOfArrays(differences2, -4, 5) == 4;

		final int[] differences3 = { 4, -7, 2 };
		assert numberOfArrays(differences3, 3, 6) == 0;

		final int[] differences4 = { -40 };
		assert numberOfArrays(differences4, -46, 53) == 60;
	}

	static int numberOfArrays(int[] differences, int lower, int upper) {
		long preSum = 0;
		long minPreSum = 0;
		long maxPreSum = 0;

		for (int delta : differences) {
			preSum = preSum + delta;
			minPreSum = Math.min(minPreSum, preSum);
			maxPreSum = Math.max(maxPreSum, preSum);
		}
		final long s1 = lower - minPreSum;
		final long s2 = upper - maxPreSum;
		if (s2 >= s1)
			return (int) (s2 - s1 + 1);
		return 0;
	}
}
