package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.Map;

class CountSpecialTriplets {
	private static final int MOD = 1000000007;

	CountSpecialTriplets() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 6, 3, 6 };
		assert specialTriplets(nums1) == 1;

		final int[] nums2 = { 0, 1, 0, 0 };
		assert specialTriplets(nums2) == 1;

		final int[] nums3 = { 8, 4, 2, 8, 4 };
		assert specialTriplets(nums3) == 2;
	}

	static int specialTriplets(int[] nums) {
		final Map<Integer, Integer> f = new HashMap<>();
		for (int v : nums)
			f.merge(v, 1, Integer::sum);

		final Map<Integer, Integer> t = new HashMap<>();
		int c = 0;
		for (int val : nums) {
			final int target = val * 2;
			if (t.containsKey(target)) {
				final int beforeCnt = t.get(target);
				final int totalCnt = f.get(target);
				int afterCnt = totalCnt - beforeCnt;
				if (val == 0)
					afterCnt = afterCnt - 1;
				final long tmp = (long) beforeCnt * afterCnt;
				c = (int) ((c + (tmp % MOD)) % MOD);
			}
			t.merge(val, 1, Integer::sum);
		}
		return c;
	}
}
