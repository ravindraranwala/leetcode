package com.coding.challenge.greedy;

class BrokenCalculator {
	BrokenCalculator() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert brokenCalc(2, 3) == 2;
		assert brokenCalc(5, 8) == 2;
		assert brokenCalc(3, 10) == 3;
	}

	static int brokenCalc(int startValue, int target) {
		int steps = 0;
		while (target > startValue) {
			if (target % 2 == 0)
				target = target / 2;
			else
				target = target + 1;
			steps = steps + 1;
		}
		return steps + startValue - target;
	}
}
