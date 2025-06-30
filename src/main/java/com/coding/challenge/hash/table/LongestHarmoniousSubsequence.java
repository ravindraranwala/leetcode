package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class LongestHarmoniousSubsequence {
	LongestHarmoniousSubsequence() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 3, 2, 2, 5, 2, 3, 7 };
		assert findLHS(nums1) == 5;

		final int[] nums2 = { 1, 2, 3, 4 };
		assert findLHS(nums2) == 2;

		final int[] nums3 = { 1, 1, 1, 1 };
		assert findLHS(nums3) == 0;
	}

	static int findLHS(int[] nums) {
		final Map<Integer, Integer> f = new HashMap<>();
		for (int v : nums)
			f.merge(v, 1, Integer::sum);

		int l = 0;
		for (Entry<Integer, Integer> e : f.entrySet()) {
			final int key = e.getKey();
			if (f.containsKey(key + 1))
				l = Math.max(l, e.getValue() + f.get(key + 1));
		}
		return l;
	}
}
