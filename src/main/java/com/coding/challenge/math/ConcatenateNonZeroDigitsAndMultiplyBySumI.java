package com.coding.challenge.math;

class ConcatenateNonZeroDigitsAndMultiplyBySumI {
	ConcatenateNonZeroDigitsAndMultiplyBySumI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert sumAndMultiply(10203004) == 12340;
		assert sumAndMultiply(1000) == 1;
	}

	static long sumAndMultiply(int n) {
		int s = 0;
		int v = 0;
		for (int curr = n, decVal = 1; curr > 0; curr = curr / 10) {
			final int d = curr % 10;
			if (d > 0) {
				v = d * decVal + v;
				s = s + d;
				decVal = decVal * 10;
			}
		}
		return s * (long) v;
	}
}
