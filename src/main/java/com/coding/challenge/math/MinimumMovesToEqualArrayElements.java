package com.coding.challenge.math;

class MinimumMovesToEqualArrayElements {
	MinimumMovesToEqualArrayElements() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3 };
		assert minMoves(nums1) == 3;

		final int[] nums2 = { 1, 1, 1 };
		assert minMoves(nums2) == 0;
	}

	static int minMoves(int[] nums) {
		int minElt = Integer.MAX_VALUE;
		for (int val : nums)
			minElt = Math.min(minElt, val);

		int m = 0;
		for (int val : nums)
			m = m + val - minElt;

		return m;
	}
}
