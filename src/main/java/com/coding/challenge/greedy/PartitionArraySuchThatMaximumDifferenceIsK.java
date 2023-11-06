package com.coding.challenge.greedy;

import java.util.Arrays;

class PartitionArraySuchThatMaximumDifferenceIsK {
	PartitionArraySuchThatMaximumDifferenceIsK() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 3, 6, 1, 2, 5 };
		System.out.println(partitionArray(numsOne, 2));

		final int[] numsTwo = { 1, 2, 3 };
		System.out.println(partitionArray(numsTwo, 1));

		final int[] numsThree = { 2, 2, 4, 5 };
		System.out.println(partitionArray(numsThree, 0));
	}

	static int partitionArray(int[] nums, int k) {
		final int n = nums.length;
		if (n == 0)
			return 0;
		Arrays.sort(nums);
		int c = 1;

		for (int i = 0, j = 0; j < n; j++) {
			if (nums[j] - nums[i] > k) {
				i = j;
				c = c + 1;
			}
		}
		return c;
	}
}
