package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.Map;

class CountNumberOfBadPairs {
	CountNumberOfBadPairs() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 4, 1, 3, 3 };
		assert countBadPairs(nums1) == 5;

		final int[] nums2 = { 1, 2, 3, 4, 5 };
		assert countBadPairs(nums2) == 0;
	}

	static long countBadPairs(int[] nums) {
		final int n = nums.length;
		final Map<Integer, Long> f = new HashMap<>();
		long totalPairs = 0;
		long goodPairs = 0;

		for (int i = 0; i < n; i++) {
			totalPairs = totalPairs + n - i - 1;
			final int delta = nums[i] - i;
			if (f.containsKey(delta))
				goodPairs = goodPairs + f.get(delta);

			f.merge(delta, 1l, Long::sum);
		}
		return totalPairs - goodPairs;
	}
}
