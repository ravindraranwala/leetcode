package com.coding.challenge.two.pointer;

import java.util.Arrays;

class KdiffPairs {
	KdiffPairs() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 3, 1, 4, 1, 5 };
		assert findPairs(numsOne, 2) == 2;

		final int[] numsTwo = { 1, 2, 3, 4, 5 };
		assert findPairs(numsTwo, 1) == 4;

		final int[] numsThree = { 1, 3, 1, 5, 4 };
		assert findPairs(numsThree, 0) == 1;
	}

	static int findPairs(int[] nums, int k) {
		Arrays.sort(nums);
		final int n = nums.length;
		int c = 0;
		for (int i = 0, j = 0, prevAns = Integer.MIN_VALUE; j < n; j++) {
			while (j > i && nums[j] - nums[i] > k)
				i = i + 1;

			// avoids double counting while ensuring uniqueness.
			if (j > i && prevAns != nums[i] && nums[j] - nums[i] == k) {
				c = c + 1;
				prevAns = nums[i];
			}
		}
		return c;
	}
}
