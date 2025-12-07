package com.coding.challenge.math;

class CountOddNumbersInAnIntervalRange {
	CountOddNumbersInAnIntervalRange() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert countOdds(3, 7) == 3;
		assert countOdds(8, 10) == 1;
		assert countOdds(2, 10) == 4;
		assert countOdds(2, 11) == 5;
		assert countOdds(1, 20) == 10;
	}

	static int countOdds(int low, int high) {
		if (low % 2 == 1 && high % 2 == 1)
			return (high - low + 1) / 2 + 1;

		return (high - low + 1) / 2;
	}
}
