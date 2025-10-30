package com.coding.challenge.bit.manipulation;

class SmallestNumberWithAllSetBits {
	SmallestNumberWithAllSetBits() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert smallestNumber(5) == 7;
		assert smallestNumber(10) == 15;
		assert smallestNumber(3) == 3;
	}

	static int smallestNumber(int n) {
		int d = 1;
		int v = 0;
		int currVal = n;
		while (currVal > 0) {
			final int lsb = currVal & 1;
			if (lsb == 0)
				v = v + d;

			d = d + d;
			currVal = currVal >> 1;
		}
		return n + v;
	}
}
