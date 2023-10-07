package com.coding.challenge.greedy;

import java.util.Arrays;

class MinimumIncrementToMakeArrayUnique {
	MinimumIncrementToMakeArrayUnique() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 2, 2 };
		assert minIncrementForUnique(numsOne) == 1;

		final int[] numsTwo = { 3, 2, 1, 2, 1, 7 };
		assert minIncrementForUnique(numsTwo) == 6;

		final int[] numsThree = { 0, 2, 2 };
		assert minIncrementForUnique(numsThree) == 1;
	}

	static int minIncrementForUnique(int[] nums) {
		final int n = nums.length;
		int s = 0;
		int dupCnt = 0;
		Arrays.sort(nums);
		for (int i = 1; i < n; i++) {
			if (nums[i] == nums[i - 1]) {
				dupCnt = dupCnt + 1;
				s = s - nums[i];
			}

			for (int val = nums[i - 1] + 1; dupCnt > 0 && val < nums[i]; val++) {
				s = s + val;
				dupCnt = dupCnt - 1;
			}
		}
		for (; dupCnt > 0; dupCnt--)
			s = s + nums[n - 1] + dupCnt;

		return s;
	}
}
