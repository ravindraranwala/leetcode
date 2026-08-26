package com.coding.challenge.hash.table;

import java.util.HashSet;
import java.util.Set;

class SmallestMissingMultipleOfK {
	SmallestMissingMultipleOfK() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 8, 2, 3, 4, 6 };
		assert missingMultiple(nums1, 2) == 10;

		final int[] nums2 = { 1, 4, 7, 10, 15 };
		assert missingMultiple(nums2, 5) == 5;
	}

	static int missingMultiple(int[] nums, int k) {
		final Set<Integer> s = new HashSet<>();
		for (int val : nums)
			s.add(val);

		final int l = nums.length;
		for (int i = 1; i <= l + 1; i++)
			if (!s.contains(i * k))
				return k * i;

		throw new AssertionError();
	}
}
