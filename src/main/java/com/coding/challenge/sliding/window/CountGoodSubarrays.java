package com.coding.challenge.sliding.window;

import java.util.HashMap;
import java.util.Map;

class CountGoodSubarrays {
	CountGoodSubarrays() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 1, 1, 1, 1 };
		assert countGood(numsOne, 10) == 1;

		final int[] numsTwo = { 3, 1, 4, 3, 2, 2, 4 };
		assert countGood(numsTwo, 2) == 4;
	}

	static long countGood(int[] nums, int k) {
		final int n = nums.length;
		final Map<Integer, Integer> freq = new HashMap<>();
		long c = 0;
		for (int i = 0, j = 0, pairs = 0; j < n; j++) {
			pairs = pairs + freq.getOrDefault(nums[j], 0);
			freq.merge(nums[j], 1, Integer::sum);
			while (pairs >= k) {
				c = c + n - j;
				pairs = pairs - freq.get(nums[i]) + 1;
				freq.put(nums[i], freq.get(nums[i]) - 1);
				if (freq.get(nums[i]) == 0)
					freq.remove(nums[i]);
				i = i + 1;
			}
		}
		return c;
	}
}
