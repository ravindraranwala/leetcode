package com.coding.challenge.bit.manipulation;

class ReverseBits {
	private static final char ZERO = '0';
	private static final char ONE = '1';

	ReverseBits() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert reverseBits(43261596) == 964176192;
		assert reverseBits(2147483644) == 1073741822;
	}

	static int reverseBits(int n) {
		// decimal to binary encode.
		final char[] bits = new char[32];
		int val = n;
		int j = 0;
		while (val > 0) {
			// reverse bits string.
			bits[j] = val % 2 == 0 ? ZERO : ONE;
			val = val / 2;
			j = j + 1;
		}

		while (j < 32) {
			bits[j] = ZERO;
			j = j + 1;
		}

		// binary to decimal decode.
		int ans = 0;
		for (int i = 31, posVal = 1; i >= 0; i--) {
			if (bits[i] == ONE)
				ans = ans + posVal;
			posVal = posVal * 2;
		}
		return ans;
	}
}
