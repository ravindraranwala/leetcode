package com.coding.challenge.greedy;

import java.util.PriorityQueue;

class MinimumOperationsToExceedThresholdValueII {
	MinimumOperationsToExceedThresholdValueII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 11, 10, 1, 3 };
		assert minOperations(nums1, 10) == 2;

		final int[] nums2 = { 1, 1, 2, 4, 9 };
		assert minOperations(nums2, 20) == 4;

		final int[] nums3 = { 999999999, 999999999, 999999999 };
		assert minOperations(nums3, 1000000000) == 2;
	}

	static int minOperations(int[] nums, int k) {
		final PriorityQueue<Long> h = new PriorityQueue<>();
		for (long val : nums)
			h.add(val);

		int c = 0;
		while (h.peek() < k) {
			final long v1 = h.poll();
			final long v2 = h.poll();
			h.add(2 * v1 + v2);
			c = c + 1;
		}
		return c;
	}
}
