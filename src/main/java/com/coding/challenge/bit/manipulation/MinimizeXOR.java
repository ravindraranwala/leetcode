package com.coding.challenge.bit.manipulation;

class MinimizeXOR {
	MinimizeXOR() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minimizeXor(3, 5) == 3;
		assert minimizeXor(1, 12) == 3;
		assert minimizeXor(99, 63) == 111;
		assert minimizeXor(25, 72) == 24;
	}

	static int minimizeXor(int num1, int num2) {
		// count the number of set bits.
		final int setBitsCnt1 = setBits(num1);
		final int setBitsCnt2 = setBits(num2);
		int x = num1;
		// Greedy algorithm.
		for (int val = 1, c = setBitsCnt1 - setBitsCnt2; val <= num1 && c > 0; val = val << 1) {
			x = ~(~x | val);
			c = c - (num1 & val) / val;
		}

		for (int val = 1, c = setBitsCnt2 - setBitsCnt1; c > 0; val = val << 1) {
			x = x | val;
			c = c - (~num1 & val) / val;
		}
		return x;
	}

	private static int setBits(int num) {
		int setBits = 0;
		for (int val = num; val > 0; val = val >> 1)
			setBits = setBits + (val & 1);

		return setBits;
	}
}
