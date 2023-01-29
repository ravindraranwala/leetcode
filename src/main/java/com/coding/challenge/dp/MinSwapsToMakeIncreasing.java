package com.coding.challenge.dp;

class MinSwapsToMakeIncreasing {
	MinSwapsToMakeIncreasing() {
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

		final int[] numsNine = { 3, 3, 8, 9, 10 };
		final int[] numsTen = { 1, 7, 4, 6, 8 };
		assert minSwap(numsNine, numsTen) == 1;

		final int[] numsEleven = { 0, 1, 4, 6, 8 };
		final int[] numsTwelve = { 1, 2, 2, 7, 10 };
		assert minSwap(numsEleven, numsTwelve) == 1;
	}

	static int minSwap(int[] nums1, int[] nums2) {
		final int n = nums1.length;
		int prevUc = 0;
		int prevSc = 1;
		for (int i = 1; i < n; i++) {
			int currUc = Integer.MAX_VALUE;
			// first consider unswapped case.
			// unswapped to unswapped
			if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i])
				currUc = prevUc;
			// swapped to unswapped
			if (nums2[i - 1] < nums1[i] && nums1[i - 1] < nums2[i])
				currUc = Math.min(currUc, prevSc);

			// then consider the swapped case.
			int currSc = Integer.MAX_VALUE;
			// unswap to swap
			// + 1 attributes to the current swap.
			if (nums1[i - 1] < nums2[i] && nums2[i - 1] < nums1[i])
				currSc = prevUc + 1;
			// swap to swap
			if (nums2[i - 1] < nums2[i] && nums1[i - 1] < nums1[i])
				currSc = Math.min(currSc, prevSc + 1);

			// moving to the next step.
			prevUc = currUc;
			prevSc = currSc;
		}

		return Math.min(prevUc, prevSc);
	}
}
