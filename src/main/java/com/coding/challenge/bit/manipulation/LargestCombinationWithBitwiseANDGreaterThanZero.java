package com.coding.challenge.bit.manipulation;

class LargestCombinationWithBitwiseANDGreaterThanZero {
	LargestCombinationWithBitwiseANDGreaterThanZero() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] candidates1 = { 16, 17, 71, 62, 12, 24, 14 };
		assert largestCombination(candidates1) == 4;

		final int[] candidates2 = { 8, 8 };
		assert largestCombination(candidates2) == 2;
	}

	static int largestCombination(int[] candidates) {
		int l = 0;
		for (int val = 1; val <= 10000000; val = val * 2) {
			int currLen = 0;
			for (int num : candidates)
				if ((num & val) == val)
					currLen = currLen + 1;

			l = Math.max(l, currLen);
		}
		return l;
	}
}
