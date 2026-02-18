package com.coding.challenge.bit.manipulation;

class ReverseBits {
	ReverseBits() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert reverseBits(43261596) == 964176192;
		assert reverseBits(2147483644) == 1073741822;
	}

	static int reverseBits(int n) {
		// decimal to binary encode.
		final int[] bits = new int[32];
		for (int val = n, j = 0; val > 0; val = val / 2) {
			// reverse bits string.
			bits[j] = val % 2;
			j = j + 1;
		}

		// binary to decimal decode.
		int ans = 0;
		for (int i = 31, posVal = 1; i >= 0; i--) {
			ans = ans + bits[i] * posVal;
			posVal = posVal * 2;
		}
		return ans;
	}
}
