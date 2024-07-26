package com.coding.challenge.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class SortArrayByIncreasingFrequency {
	SortArrayByIncreasingFrequency() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 1, 2, 2, 2, 3 };
		final int[] expected1 = { 3, 1, 1, 2, 2, 2 };
		assert Arrays.equals(expected1, frequencySort(nums1));

		final int[] nums2 = { 2, 3, 1, 3, 2 };
		final int[] expected2 = { 1, 3, 3, 2, 2 };
		assert Arrays.equals(expected2, frequencySort(nums2));

		final int[] nums3 = { -1, 1, -6, 4, 5, -6, 1, 4, 1 };
		final int[] expected3 = { 5, -1, 4, 4, -6, -6, 1, 1, 1 };
		assert Arrays.equals(expected3, frequencySort(nums3));
	}

	static int[] frequencySort(int[] nums) {
		final int n = nums.length;
		final Integer[] a = new Integer[n];
		final Map<Integer, Integer> f = new HashMap<>();
		for (int i = 0; i < n; i++) {
			f.merge(nums[i], 1, Integer::sum);
			a[i] = nums[i];
		}

		final Comparator<Integer> cmp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				final int f1 = f.get(o1);
				final int f2 = f.get(o2);
				if (f1 == f2)
					return o2.compareTo(o1);

				return Integer.compare(f1, f2);
			}
		};
		Arrays.sort(a, cmp);
		final int[] sorted = new int[n];
		for (int i = 0; i < n; i++)
			sorted[i] = a[i];

		return sorted;
	}
}
