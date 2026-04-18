package com.coding.challenge.math;

import java.util.HashMap;
import java.util.Map;

class MinimumAbsoluteDistanceBetweenMirrorPairs {
	MinimumAbsoluteDistanceBetweenMirrorPairs() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 12, 21, 45, 33, 54 };
		assert minMirrorPairDistance(nums1) == 1;

		final int[] nums2 = { 120, 21 };
		assert minMirrorPairDistance(nums2) == 1;

		final int[] nums3 = { 21, 120 };
		assert minMirrorPairDistance(nums3) == -1;
	}

	static int minMirrorPairDistance(int[] nums) {
		final int n = nums.length;
		final Map<Integer, Integer> t = new HashMap<>();
		int d = n;

		for (int i = n - 1; i >= 0; i--) {
			final int val = reverseNumber(nums[i]);
			if (t.containsKey(val))
				d = Math.min(d, t.get(val) - i);

			t.put(nums[i], i);
		}
		return d == n ? -1 : d;
	}

	private static int reverseNumber(int n) {
		int ans = 0;
		for (int curr = n; curr > 0; curr = curr / 10)
			ans = ans * 10 + (curr % 10);

		return ans;
	}
}
