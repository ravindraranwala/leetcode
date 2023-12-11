package com.coding.challenge.prefix.sum;

import java.util.HashMap;
import java.util.Map;

class MaxNumOfNonOverlappingSubarrsWithSumEqTarget {
	MaxNumOfNonOverlappingSubarrsWithSumEqTarget() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 1, 1, 1, 1 };
		assert maxNonOverlapping(nums1, 2) == 2;

		final int[] nums2 = { -1, 3, 5, 1, 4, 2, -9 };
		assert maxNonOverlapping(nums2, 6) == 2;

		final int[] nums3 = { -2, 6, 6, 3, 5, 4, 1, 2, 8 };
		assert maxNonOverlapping(nums3, 10) == 3;

		final int[] nums4 = { 0, 0, 0 };
		assert maxNonOverlapping(nums4, 0) == 3;

		final int[] nums5 = { -1, -2, 8, -3, 8, -5, 5, -4, 5, 4, 1 };
		assert maxNonOverlapping(nums5, 5) == 5;

		final int[] nums6 = { -1, 0, 2, 2, 3, -1, 3, 0, 2, 0, 3, 3, 1, 3, 1, -1, 1, 3, 1, 2, 2, -1, 2, -1, 3, 2, 3, -1,
				0, -1, -1, -1, -1, 0, 0, 0, 2, 0, 1, -1, 0, 2, 1, 3, 0, 2, 3, 1 };
		// expected 11.
		assert maxNonOverlapping(nums6, 4) == 11;
	}

	static int maxNonOverlapping(int[] nums, int target) {
		final Map<Integer, Integer> t = new HashMap<>();
		t.put(0, -1);
		final int n = nums.length;
		final int[] a = new int[n];
		int c = 0;
		for (int j = 0, s = 0; j < n; j++) {
			s = s + nums[j];
			if (t.containsKey(s - target)) {
				final int i = t.get(s - target);
				if (i >= 0)
					a[j] = Math.max(c, a[i] + 1);
				else
					a[j] = Math.max(c, 1);
				c = Math.max(c, a[j]);
			} else
				a[j] = c;
			t.put(s, j);
		}
		return c;
	}
}
