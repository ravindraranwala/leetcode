package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.Map;

class TupleWithSameProduct {
	TupleWithSameProduct() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 3, 4, 6 };
		assert tupleSameProduct(nums1) == 8;

		final int[] nums2 = { 1, 2, 4, 5, 10 };
		assert tupleSameProduct(nums2) == 16;
	}

	static int tupleSameProduct(int[] nums) {
		final int n = nums.length;
		final Map<Integer, Integer> t = new HashMap<>();

		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				t.merge(nums[i] * nums[j], 1, Integer::sum);

		int c = 0;
		for (int freq : t.values())
			c = c + 4 * (freq - 1) * freq;

		return c;
	}
}
