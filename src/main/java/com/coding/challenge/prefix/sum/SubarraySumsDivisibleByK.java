package com.coding.challenge.prefix.sum;

import java.util.HashMap;
import java.util.Map;

class SubarraySumsDivisibleByK {
	SubarraySumsDivisibleByK() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 4, 5, 0, -2, -3, 1 };
		assert subarraysDivByK(nums1, 5) == 7;

		final int[] nums2 = { 5 };
		assert subarraysDivByK(nums2, 9) == 0;

		final int[] nums3 = { -1, 2, 9 };
		assert subarraysDivByK(nums3, 2) == 2;

		final int[] nums4 = { 2, -2, 2, -4 };
		assert subarraysDivByK(nums4, 6) == 2;

		final int[] nums5 = { -5 };
		assert subarraysDivByK(nums5, 5) == 1;
	}

	static int subarraysDivByK(int[] nums, int k) {
		final int n = nums.length;
		final Map<Integer, Integer> modFreq = new HashMap<>();
		modFreq.put(0, 1);
		int c = 0;
		for (int i = 0, s = 0; i < n; i++) {
			s = s + nums[i];
			// Use Euclidean division instead of the remainder.
			int mod = s % k;
			if (mod < 0)
				mod = mod + k;
			if (modFreq.containsKey(mod))
				c = c + modFreq.get(mod);
			modFreq.merge(mod, 1, Integer::sum);
		}
		return c;
	}
}
