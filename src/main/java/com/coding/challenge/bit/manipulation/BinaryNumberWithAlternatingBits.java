package com.coding.challenge.bit.manipulation;

class BinaryNumberWithAlternatingBits {
	BinaryNumberWithAlternatingBits() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert hasAlternatingBits(5);
		assert !hasAlternatingBits(7);
		assert !hasAlternatingBits(11);
	}

	static boolean hasAlternatingBits(int n) {
		for (int val = n, prev = 2; val > 0; val = val / 2) {
			final int mod = val % 2;
			if (mod == prev)
				return false;

			prev = mod;
		}

		return true;
	}
}
