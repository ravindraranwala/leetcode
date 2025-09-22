package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.Map;

class CountElementsWithMaximumFrequency {
	CountElementsWithMaximumFrequency() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 2, 3, 1, 4 };
		assert maxFrequencyElements(nums1) == 4;

		final int[] nums2 = { 1, 2, 3, 4, 5 };
		assert maxFrequencyElements(nums2) == 5;
	}

	static int maxFrequencyElements(int[] nums) {
		final Map<Integer, Integer> f = new HashMap<>();
		for (int v : nums)
			f.merge(v, 1, Integer::sum);

		int maxFreq = 0;
		for (int freq : f.values())
			maxFreq = Math.max(maxFreq, freq);

		int c = 0;
		for (int freq : f.values())
			if (freq == maxFreq)
				c = c + freq;

		return c;
	}
}
