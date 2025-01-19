package com.coding.challenge.bit.manipulation;

class NeighboringBitwiseXOR {
	NeighboringBitwiseXOR() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] derived1 = { 1, 1, 0 };
		assert doesValidArrayExist(derived1);

		final int[] derived2 = { 1, 1 };
		assert doesValidArrayExist(derived2);

		final int[] derived3 = { 1, 0 };
		assert !doesValidArrayExist(derived3);
	}

	static boolean doesValidArrayExist(int[] derived) {
		int xor = 0;
		for (int val : derived)
			xor = xor ^ val;
		return xor == 0;
	}
}
