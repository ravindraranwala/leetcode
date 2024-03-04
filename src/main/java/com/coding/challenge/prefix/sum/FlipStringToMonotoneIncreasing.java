package com.coding.challenge.prefix.sum;

class FlipStringToMonotoneIncreasing {
	FlipStringToMonotoneIncreasing() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minFlipsMonoIncr("00110") == 1;
		assert minFlipsMonoIncr("010110") == 2;
		assert minFlipsMonoIncr("00011000") == 2;
	}

	static int minFlipsMonoIncr(String s) {
		final int n = s.length();
		int suffixZeros = 0;
		for (int i = n - 1; i >= 0; i--)
			if (s.charAt(i) == '0')
				suffixZeros = suffixZeros + 1;

		int flips = suffixZeros;
		for (int i = 0, prefixOnes = 0; i < n; i++) {
			if (s.charAt(i) == '1')
				prefixOnes = prefixOnes + 1;
			else
				suffixZeros = suffixZeros - 1;
			flips = Math.min(flips, prefixOnes + suffixZeros);
		}
		return flips;
	}
}
