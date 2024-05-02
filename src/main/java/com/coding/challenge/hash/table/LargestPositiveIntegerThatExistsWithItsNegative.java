package com.coding.challenge.hash.table;

import java.util.HashSet;
import java.util.Set;

class LargestPositiveIntegerThatExistsWithItsNegative {
	LargestPositiveIntegerThatExistsWithItsNegative() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { -1, 2, -3, 3 };
		assert findMaxK(nums1) == 3;

		final int[] nums2 = { -1, 10, 6, 7, -7, 1 };
		assert findMaxK(nums2) == 7;

		final int[] nums3 = { -10, 8, 6, 7, -2, -3 };
		assert findMaxK(nums3) == -1;
	}

	static int findMaxK(int[] nums) {
		final Set<Integer> t = new HashSet<>();
		int ans = -1;
		for (int v : nums) {
			t.add(v);
			if (t.contains(-v))
				ans = Math.max(ans, Math.abs(v));
		}
		return ans;
	}
}
