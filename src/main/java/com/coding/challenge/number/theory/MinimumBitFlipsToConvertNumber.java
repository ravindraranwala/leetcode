package com.coding.challenge.number.theory;

class MinimumBitFlipsToConvertNumber {
	MinimumBitFlipsToConvertNumber() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minBitFlips(10, 7) == 3;
		assert minBitFlips(3, 4) == 3;
		assert minBitFlips(81, 87) == 2;
	}

	static int minBitFlips(int start, int goal) {
		int c = 0;
		for (int num1 = start, num2 = goal; num1 > 0 || num2 > 0; num1 = num1 / 2, num2 = num2 / 2)
			c = c + ((num1 % 2) ^ (num2 % 2));

		return c;
	}
}
