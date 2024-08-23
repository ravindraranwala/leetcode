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
		int currNum = 1;
		int allOneVal = 1;
		while (allOneVal < num) {
			currNum = currNum * 2;
			allOneVal = allOneVal + currNum;
		}
		return allOneVal - num;
	}
}
