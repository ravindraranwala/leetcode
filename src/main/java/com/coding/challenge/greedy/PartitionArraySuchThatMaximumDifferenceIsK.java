package com.coding.challenge.greedy;

import java.util.Arrays;

class PartitionArraySuchThatMaximumDifferenceIsK {
	PartitionArraySuchThatMaximumDifferenceIsK() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 3, 6, 1, 2, 5 };
		assert partitionArray(nums1, 2) == 2;

		final int[] nums2 = { 1, 2, 3 };
		assert partitionArray(nums2, 1) == 2;

		final int[] nums3 = { 2, 2, 4, 5 };
		assert partitionArray(nums3, 0) == 3;
	}

	static int partitionArray(int[] nums, int k) {
		final int n = nums.length;
		Arrays.sort(nums);
		int c = 0;
		for (int i = 0, minElt = -k - 1; i < n; i++) {
			if (nums[i] - minElt > k) {
				c = c + 1;
				minElt = nums[i];
			}
		}
		return c;
	}
}
