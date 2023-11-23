package com.coding.challenge.two.pointer;

import java.util.Arrays;

class MaximizeGreatnessOfAnArray {
	MaximizeGreatnessOfAnArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 3, 5, 2, 1, 3, 1 };
		assert maximizeGreatness(numsOne) == 4;

		final int[] numsTwo = { 1, 2, 3, 4 };
		assert maximizeGreatness(numsTwo) == 3;
	}

	static int maximizeGreatness(int[] nums) {
		Arrays.sort(nums);
		int g = 0;
		final int n = nums.length;
		for (int i = 0, j = 0; i < n; i++) {
			while (j < n && nums[i] == nums[j])
				j = j + 1;
			if (j < n) {
				g = g + 1;
				j = j + 1;
			}
		}
		return g;
	}
}
