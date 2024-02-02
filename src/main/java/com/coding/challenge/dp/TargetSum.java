package com.coding.challenge.dp;

import java.util.HashMap;
import java.util.Map;

class TargetSum {
	TargetSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 1, 1, 1, 1 };
		assert findTargetSumWays(nums1, 3) == 5;

		final int[] nums2 = { 1 };
		assert findTargetSumWays(nums2, 1) == 1;

		final int[] nums3 = { 0, 0, 0, 0, 0, 0, 0, 0, 1 };
		assert findTargetSumWays(nums3, 1) == 256;
	}

	static int findTargetSumWays(int[] nums, int target) {
		final int n = nums.length;
		Map<Integer, Integer> currState = new HashMap<>();
		currState.put(0, 1);

		for (int i = 0; i < n; i++) {
			final Map<Integer, Integer> newState = new HashMap<>();
			for (int key : currState.keySet()) {
				final int f = currState.get(key);
				newState.merge(key + nums[i], f, Integer::sum);
				newState.merge(key - nums[i], f, Integer::sum);
			}
			currState = newState;
		}
		return currState.getOrDefault(target, 0);
	}
}
