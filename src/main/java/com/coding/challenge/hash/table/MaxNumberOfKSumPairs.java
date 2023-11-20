package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.Map;

class MaxNumberOfKSumPairs {
	MaxNumberOfKSumPairs() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 2, 3, 4 };
		assert maxOperations(numsOne, 5) == 2;

		final int[] numsTwo = { 3, 1, 3, 4, 3 };
		assert maxOperations(numsTwo, 6) == 1;
	}

	static int maxOperations(int[] nums, int k) {
		final Map<Integer, Integer> f = new HashMap<>();
		int c = 0;
		final int n = nums.length;
		for (int i = 0; i < n; i++) {
			final int v = k - nums[i];
			if (f.getOrDefault(v, 0) > 0) {
				c = c + 1;
				f.put(v, f.get(v) - 1);
			} else
				f.merge(nums[i], 1, Integer::sum);
		}
		return c;
	}
}
