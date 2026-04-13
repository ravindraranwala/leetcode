package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.Map;

class MinimumDistanceBetweenThreeEqualElementsI {
	MinimumDistanceBetweenThreeEqualElementsI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 1, 1, 3 };
		assert minimumDistance(nums1) == 6;

		final int[] nums2 = { 1, 1, 2, 3, 2, 1, 2 };
		assert minimumDistance(nums2) == 8;

		final int[] nums3 = { 1 };
		assert minimumDistance(nums3) == -1;
	}

	static int minimumDistance(int[] nums) {
		final int n = nums.length;
		final Map<Integer, Integer> prev = new HashMap<>();
		final Map<Integer, Integer> beforePrev = new HashMap<>();
		int d = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			if (beforePrev.containsKey(nums[i])) {
				final int j = beforePrev.get(nums[i]);
				final int diff = i - j;
				d = Math.min(d, diff + diff);
			}

			if (prev.containsKey(nums[i])) {
				beforePrev.put(nums[i], prev.get(nums[i]));
				prev.put(nums[i], i);
			} else
				prev.put(nums[i], i);
		}
		return d == Integer.MAX_VALUE ? -1 : d;
	}
}
