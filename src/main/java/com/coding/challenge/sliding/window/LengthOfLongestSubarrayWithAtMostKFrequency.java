package com.coding.challenge.sliding.window;

import java.util.HashMap;
import java.util.Map;

class LengthOfLongestSubarrayWithAtMostKFrequency {
	LengthOfLongestSubarrayWithAtMostKFrequency() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3, 1, 2, 3, 1, 2 };
		assert maxSubarrayLength(nums1, 2) == 6;

		final int[] nums2 = { 1, 2, 1, 2, 1, 2, 1, 2 };
		assert maxSubarrayLength(nums2, 1) == 2;

		final int[] nums3 = { 5, 5, 5, 5, 5, 5, 5 };
		assert maxSubarrayLength(nums3, 4) == 4;
	}

	static int maxSubarrayLength(int[] nums, int k) {
		final int n = nums.length;
		final Map<Integer, Integer> f = new HashMap<>();
		int freqGreaterThanK = 0;
		int l = 0;
		for (int s = 0, e = 0; e < n; e++) {
			f.merge(nums[e], 1, Integer::sum);
			if (f.get(nums[e]) == k + 1)
				freqGreaterThanK = freqGreaterThanK + 1;
			while (freqGreaterThanK > 0) {
				f.put(nums[s], f.get(nums[s]) - 1);
				if (f.get(nums[s]) == k)
					freqGreaterThanK = freqGreaterThanK - 1;
				s = s + 1;
			}
			l = Math.max(l, e - s + 1);
		}
		return l;
	}
}
