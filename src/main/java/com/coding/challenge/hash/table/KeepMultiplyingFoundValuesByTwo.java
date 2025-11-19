package com.coding.challenge.hash.table;

import java.util.HashSet;
import java.util.Set;

class KeepMultiplyingFoundValuesByTwo {
	KeepMultiplyingFoundValuesByTwo() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 5, 3, 6, 1, 12 };
		assert findFinalValue(nums1, 3) == 24;

		final int[] nums2 = { 2, 7, 9 };
		assert findFinalValue(nums2, 4) == 4;
	}

	static int findFinalValue(int[] nums, int original) {
		final Set<Integer> s = new HashSet<>();
		for (int v : nums)
			s.add(v);

		int currOriginal = original;
		while (s.contains(currOriginal))
			currOriginal = currOriginal * 2;

		return currOriginal;
	}
}
