package com.coding.challenge.math;

import com.coding.challenge.quick.select.QuickSelect;

class MinimumMovesToEqualArrayElementsII {
	MinimumMovesToEqualArrayElementsII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3 };
		assert minMoves(nums1) == 2;

		final int[] nums2 = { 1, 10, 2, 9 };
		assert minMoves(nums2) == 16;
	}

	static int minMoves(int[] nums) {
		final int n = nums.length;
		final int median = QuickSelect.randomizedSelect(nums, 0, n - 1, (n + 1) / 2);
		int m = 0;
		for (int val : nums)
			m = m + Math.abs(val - median);

		return m;
	}
}
