package com.coding.challenge.hash.table;

import java.util.HashSet;
import java.util.Set;

class MinimumOperationsToMakeArrayValuesEqualToK {
	MinimumOperationsToMakeArrayValuesEqualToK() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 5, 2, 5, 4, 5 };
		assert minOperations(nums1, 2) == 2;

		final int[] nums2 = { 2, 1, 2 };
		assert minOperations(nums2, 2) == -1;

		final int[] nums3 = { 9, 7, 5, 3 };
		assert minOperations(nums3, 1) == 4;
	}

	static int minOperations(int[] nums, int k) {
		final Set<Integer> s = new HashSet<>();
		int min = Integer.MAX_VALUE;
		for (int val : nums) {
			s.add(val);
			min = Math.min(min, val);
		}

		if (k == min)
			return s.size() - 1;
		if (k < min)
			return s.size();
		return -1;
	}
}
