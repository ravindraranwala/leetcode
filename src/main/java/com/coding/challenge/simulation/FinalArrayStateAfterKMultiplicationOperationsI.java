package com.coding.challenge.simulation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class FinalArrayStateAfterKMultiplicationOperationsI {
	FinalArrayStateAfterKMultiplicationOperationsI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 1, 3, 5, 6 };
		final int[] e1 = { 8, 4, 6, 5, 6 };
		assert Arrays.equals(e1, getFinalState(nums1, 5, 2));

		final int[] nums2 = { 1, 2 };
		final int[] e2 = { 16, 8 };
		assert Arrays.equals(e2, getFinalState(nums2, 3, 4));
	}

	static int[] getFinalState(int[] nums, int k, int multiplier) {
		final int n = nums.length;
		final Comparator<Integer> cmp = new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				final int c = Integer.compare(nums[a], nums[b]);
				if (c == 0)
					return Integer.compare(a, b);
				return c;
			}
		};
		final PriorityQueue<Integer> h = new PriorityQueue<>(cmp);
		for (int i = 0; i < n; i++)
			h.add(i);

		for (int i = 0; i < k; i++) {
			final int j = h.remove();
			nums[j] = nums[j] * multiplier;
			h.add(j);
		}
		return nums;
	}
}
