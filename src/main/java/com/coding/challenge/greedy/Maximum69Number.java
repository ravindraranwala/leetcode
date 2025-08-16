package com.coding.challenge.greedy;

class Maximum69Number {
	Maximum69Number() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maximum69Number(9669) == 9969;
		assert maximum69Number(9996) == 9999;
		assert maximum69Number(9999) == 9999;
	}

	static int maximum69Number(int num) {
		int curr = num;
		int decimalPosVal = 1;
		int lastSixDecimalPosVal = 0;
		while (curr != 0) {
			if (curr % 10 == 6)
				lastSixDecimalPosVal = decimalPosVal;

			curr = curr / 10;
			decimalPosVal = decimalPosVal * 10;
		}
		return num + lastSixDecimalPosVal * 3;
	}
}
