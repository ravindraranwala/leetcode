package com.coding.challenge.dp;

class MinSwapsToMakeIncreasing {
	public MinSwapsToMakeIncreasing() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 3, 5, 4 };
		final int[] numsTwo = { 1, 2, 3, 7 };
		assert minSwap(numsOne, numsTwo) == 1;

		final int[] numsThree = { 0, 3, 5, 8, 9 };
		final int[] numsFour = { 2, 1, 4, 6, 9 };
		assert minSwap(numsThree, numsFour) == 1;

		final int[] numsFive = { 0, 4, 4, 5, 9 };
		final int[] numsSix = { 0, 1, 6, 8, 10 };
		assert minSwap(numsFive, numsSix) == 1;

		final int[] numsSeven = { 0, 3, 4, 9, 10 };
		final int[] numsEight = { 2, 3, 7, 5, 6 };
		assert minSwap(numsSeven, numsEight) == 1;

		// in this case you can swap either i = 0 or 1 in both the arrays.
		// You need to keep both the subproblem solutions and see what gives the optimal
		// solution.
		final int[] numsNine = { 3, 3, 8, 9, 10 };
		final int[] numsTen = { 1, 7, 4, 6, 8 };
		assert minSwap(numsNine, numsTen) == 1;

		// all gives answer = 1.
	}

	static int minSwap(int[] nums1, int[] nums2) {
		throw new UnsupportedOperationException();
	}
}
