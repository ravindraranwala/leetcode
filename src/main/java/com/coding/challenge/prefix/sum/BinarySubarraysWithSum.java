package com.coding.challenge.prefix.sum;

import java.util.HashMap;
import java.util.Map;

class BinarySubarraysWithSum {
	BinarySubarraysWithSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 0, 1, 0, 1 };
		assert numSubarraysWithSum(numsOne, 2) == 4;

		final int[] numsTwo = { 0, 0, 0, 0, 0 };
		assert numSubarraysWithSum(numsTwo, 0) == 15;
	}

	static int numSubarraysWithSum(int[] nums, int goal) {
		final int n = nums.length;
		final Map<Integer, Integer> f = new HashMap<>();
		// sentinel.
		f.put(0, 1);
		int c = 0;
		for (int i = 0, s = 0; i < n; i++) {
			s = s + nums[i];
			c = c + f.getOrDefault(s - goal, 0);
			f.merge(s, 1, Integer::sum);
		}
		return c;
	}
}
