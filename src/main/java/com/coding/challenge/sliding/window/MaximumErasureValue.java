package com.coding.challenge.sliding.window;

import java.util.HashSet;
import java.util.Set;

class MaximumErasureValue {
	MaximumErasureValue() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 4, 2, 4, 5, 6 };
		assert maximumUniqueSubarray(numsOne) == 17;

		final int[] numsTwo = { 5, 2, 1, 2, 5, 2, 1, 2, 5 };
		assert maximumUniqueSubarray(numsTwo) == 8;
	}

	static int maximumUniqueSubarray(int[] nums) {
		final int n = nums.length;
		final Set<Integer> s = new HashSet<>();
		int max = 0;
		for (int i = 0, j = 0, sum = 0; j < n; j++) {
			while (s.contains(nums[j])) {
				s.remove(nums[i]);
				sum = sum - nums[i];
				i = i + 1;
			}
			s.add(nums[j]);
			sum = sum + nums[j];
			max = Math.max(max, sum);
		}
		return max;
	}
}
