package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.Map;

class DivideArrayIntoEqualPairs {
	DivideArrayIntoEqualPairs() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 3, 2, 3, 2, 2, 2 };
		assert divideArray(nums1);

		final int[] nums2 = { 1, 2, 3, 4 };
		assert !divideArray(nums2);
	}

	static boolean divideArray(int[] nums) {
		final Map<Integer, Integer> f = new HashMap<>();
		for (int val : nums)
			f.merge(val, 1, Integer::sum);

		for (int v : f.values())
			if (v % 2 == 1)
				return false;

		return true;
	}
}
