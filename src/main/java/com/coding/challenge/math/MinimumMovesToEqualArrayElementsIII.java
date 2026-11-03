package com.coding.challenge.math;

class MinimumMovesToEqualArrayElementsIII {
	MinimumMovesToEqualArrayElementsIII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 1, 3 };
		assert minMoves(nums1) == 3;

		final int[] nums2 = { 4, 4, 5 };
		assert minMoves(nums2) == 2;
	}

	static int minMoves(int[] nums) {
		int maxVal = Integer.MIN_VALUE;
		for (int val : nums) {
			maxVal = Math.max(val, maxVal);

		}

		int m = 0;
		for (int val : nums) {
			m = m + maxVal - val;
		}

		return m;
	}
}
