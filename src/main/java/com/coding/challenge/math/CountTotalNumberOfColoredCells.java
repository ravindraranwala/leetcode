package com.coding.challenge.math;

class CountTotalNumberOfColoredCells {
	CountTotalNumberOfColoredCells() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert coloredCells(1) == 1;
		assert coloredCells(2) == 5;
		assert coloredCells(3) == 13;
		assert coloredCells(4) == 25;
		assert coloredCells(5) == 41;
		assert coloredCells(100000) == 19999800001l;
	}

	static long coloredCells(int n) {
		long l = 2 * n - 1;
		return l * l / 2 + 1;
	}
}
