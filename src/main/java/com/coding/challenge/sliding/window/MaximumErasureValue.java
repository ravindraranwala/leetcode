package com.coding.challenge.sliding.window;

import java.util.HashMap;
import java.util.Map;

class MaximumErasureValue {
	MaximumErasureValue() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 4, 2, 4, 5, 6 };
		assert maximumUniqueSubarray(nums1) == 17;

		final int[] nums2 = { 5, 2, 1, 2, 5, 2, 1, 2, 5 };
		assert maximumUniqueSubarray(nums2) == 8;
	}

	static int maximumUniqueSubarray(int[] nums) {
		final int n = nums.length;
		int maxScore = 0;
		final Map<Integer, Integer> w = new HashMap<>();

		for (int l = 0, r = 0, s = 0; r < n; r++) {
			if (w.containsKey(nums[r])) {
				final int k = w.get(nums[r]);
				while (l <= k) {
					w.remove(nums[l]);
					s = s - nums[l];
					l = l + 1;
				}
			}
			w.put(nums[r], r);
			s = s + nums[r];
			maxScore = Math.max(maxScore, s);
		}
		return maxScore;
	}
}
