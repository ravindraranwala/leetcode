package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.Map;

class MakeSumDivisibleByP {
	MakeSumDivisibleByP() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 3, 1, 4, 2 };
		assert minSubarray(nums1, 6) == 1;

		final int[] nums2 = { 6, 3, 5, 2 };
		assert minSubarray(nums2, 9) == 2;

		final int[] nums3 = { 1, 2, 3 };
		assert minSubarray(nums3, 3) == 0;
	}

	static int minSubarray(int[] nums, int p) {
		int r = 0;
		for (int v : nums)
			r = (r + v % p) % p;

		if (r == 0)
			return 0;

		int l = Integer.MAX_VALUE;
		final Map<Integer, Integer> t = new HashMap<>();
		t.put(0, -1);
		final int n = nums.length;
		for (int i = 0, prefixRem = 0; i < n; i++) {
			prefixRem = (prefixRem + (nums[i] % p)) % p;
			final int key = (prefixRem - r + p) % p;
			if (t.containsKey(key))
				l = Math.min(l, i - t.get(key));

			t.put(prefixRem, i);
		}

		return l < n ? l : -1;
	}
}
