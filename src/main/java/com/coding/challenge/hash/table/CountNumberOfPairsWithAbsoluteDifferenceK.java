package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.Map;

class CountNumberOfPairsWithAbsoluteDifferenceK {
	CountNumberOfPairsWithAbsoluteDifferenceK() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 2, 1 };
		assert countKDifference(nums1, 1) == 4;

		final int[] nums2 = { 1, 3 };
		assert countKDifference(nums2, 3) == 0;

		final int[] nums3 = { 3, 2, 1, 5, 4 };
		assert countKDifference(nums3, 2) == 3;
	}

	static int countKDifference(int[] nums, int k) {
		final Map<Integer, Integer> f = new HashMap<>();
		for (int num : nums)
			f.merge(num, 1, Integer::sum);

		int c = 0;
		for (int num : nums)
			c = c + f.getOrDefault(num + k, 0);

		return c;
	}
}
