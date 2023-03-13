package com.coding.challenge.sliding.window;

import java.util.HashMap;
import java.util.Map;

class DistinctSubarrayMaxSum {
	DistinctSubarrayMaxSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums = { 1, 5, 4, 2, 9, 9, 9 };
		assert maximumSubarraySum(nums, 3) == 15;

		final int[] numsTwo = { 4, 4, 4 };
		assert maximumSubarraySum(numsTwo, 3) == 0;
	}

	static long maximumSubarraySum(int[] nums, int k) {
		// Fixed size window problem.
		final int n = nums.length;
		final Map<Integer, Integer> numFreq = new HashMap<>();
		long s = 0;
		long runningSum = 0;

		for (int i = 0; i < n; i++) {
			numFreq.merge(nums[i], 1, Integer::sum);
			runningSum = runningSum + nums[i];
			if (i >= k - 1) {
				if (numFreq.size() == k)
					s = Math.max(s, runningSum);
				final int low = i - k + 1;
				numFreq.put(nums[low], numFreq.get(nums[low]) - 1);
				if (numFreq.get(nums[low]) == 0)
					numFreq.remove(nums[low]);
				runningSum = runningSum - nums[low];
			}
		}
		return s;
	}
}
