package com.coding.challenge.bit.manipulation;

class NumberComplement {
	NumberComplement() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert findComplement(5) == 2;
		assert findComplement(1) == 0;
	}

	static int findComplement(int num) {
		int allOneVal = 1;
		while (allOneVal < num)
			// binary addition is faster than multiplication.
			allOneVal = allOneVal + allOneVal + 1;

		return allOneVal - num;
	}
}
