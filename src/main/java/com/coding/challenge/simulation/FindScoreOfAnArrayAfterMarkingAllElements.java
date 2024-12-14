package com.coding.challenge.simulation;

import java.util.Arrays;
import java.util.Comparator;

class FindScoreOfAnArrayAfterMarkingAllElements {
	FindScoreOfAnArrayAfterMarkingAllElements() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 1, 3, 4, 5, 2 };
		assert findScore(nums1) == 7;

		final int[] nums2 = { 2, 3, 5, 1, 3, 2 };
		assert findScore(nums2) == 5;
	}

	static long findScore(int[] nums) {
		final Comparator<Integer> cmp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				final int result = Integer.compare(nums[o1], nums[o2]);
				if (result == 0)
					return o1.compareTo(o2);

				return result;
			}
		};

		final int n = nums.length;
		final Integer[] a = new Integer[n];
		long s = 0;
		for (int i = 0; i < n; i++)
			a[i] = i;

		Arrays.sort(a, cmp);
		final boolean[] marked = new boolean[n];
		for (int i = 0; i < n; i++) {
			final int j = a[i];
			if (!marked[j]) {
				s = s + nums[j];
				marked[j] = true;
				if (j > 0)
					marked[j - 1] = true;
				if (j < n - 1)
					marked[j + 1] = true;
			}
		}
		return s;
	}
}
