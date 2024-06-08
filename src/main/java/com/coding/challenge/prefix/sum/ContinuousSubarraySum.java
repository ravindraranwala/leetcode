package com.coding.challenge.prefix.sum;

import java.util.HashMap;
import java.util.Map;

class ContinuousSubarraySum {
	ContinuousSubarraySum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 23, 2, 4, 6, 7 };
		assert checkSubarraySum(nums1, 6);

		final int[] nums2 = { 23, 2, 6, 4, 7 };
		assert checkSubarraySum(nums2, 6);

		final int[] nums3 = { 23, 2, 6, 4, 7 };
		assert !checkSubarraySum(nums3, 13);

		final int[] nums4 = { 23, 2, 4, 6, 6 };
		assert checkSubarraySum(nums4, 7);

		final int[] nums5 = { 5, 0, 0, 0 };
		assert checkSubarraySum(nums5, 3);
	}

	static boolean checkSubarraySum(int[] nums, int k) {
		final int n = nums.length;
		final Map<Integer, Integer> t = new HashMap<>();
		t.put(0, -1);
		for (int i = 0, s = 0; i < n; i++) {
			s = s + nums[i];
			final int r = s % k;
			if (t.containsKey(r)) {
				if (i - t.get(r) > 1)
					return true;
			} else
				t.put(r, i);
		}
		return false;
	}
}
