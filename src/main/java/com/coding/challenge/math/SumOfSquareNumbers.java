package com.coding.challenge.math;

class SumOfSquareNumbers {
	SumOfSquareNumbers() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert judgeSquareSum(5);
		assert !judgeSquareSum(3);
	}

	static boolean judgeSquareSum(int c) {
		final int range = (int) Math.sqrt(c);

		for (int v = 0; v <= range; v++) {
			final int remaining = c - v * v;
			final int remainingSqrt = (int) Math.sqrt(remaining);
			if (remainingSqrt * remainingSqrt == remaining)
				return true;
		}
		return false;
	}
}
