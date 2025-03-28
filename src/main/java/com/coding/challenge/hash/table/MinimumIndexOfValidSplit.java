package com.coding.challenge.hash.table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MinimumIndexOfValidSplit {
	MinimumIndexOfValidSplit() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final List<Integer> nums1 = Arrays.asList(1, 2, 2, 2);
		assert minimumIndex(nums1) == 2;

		final List<Integer> nums2 = Arrays.asList(2, 1, 3, 1, 1, 1, 7, 1, 2, 1);
		assert minimumIndex(nums2) == 4;

		final List<Integer> nums3 = Arrays.asList(3, 3, 3, 3, 7, 2, 2);
		assert minimumIndex(nums3) == -1;
	}

	static int minimumIndex(List<Integer> nums) {
		final int n = nums.size();
		int dominantVal = -1;
		int dominantFreq = 0;
		final Map<Integer, Integer> f = new HashMap<>();
		for (int val : nums) {
			final int freq = f.merge(val, 1, Integer::sum);
			if (freq * 2 > n) {
				dominantVal = val;
				dominantFreq = freq;
			}
		}

		for (int i = 0, freq = 0; i < n - 1; i++) {
			if (nums.get(i) == dominantVal)
				freq = freq + 1;
			// is it a valid split.
			if (freq * 2 > i + 1 && (dominantFreq - freq) * 2 > (n - i - 1))
				return i;
		}
		return -1;
	}
}
