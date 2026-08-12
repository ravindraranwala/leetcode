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
		final Map<Integer, Integer> freq = new HashMap<>();
		int l = 0;
		for (int i = 0, j = 0; j < n; j++) {
			freq.merge(nums[j], 1, Integer::sum);
			while (freq.get(nums[j]) > k) {
				freq.put(nums[i], freq.get(nums[i]) - 1);
				i = i + 1;
			}
			l = Math.max(l, j - i + 1);
		}
		return l;
	}
}
