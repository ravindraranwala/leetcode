package com.coding.challenge.hash.table;

import java.util.Arrays;

class IntersectionOfTwoArrays_II {
	IntersectionOfTwoArrays_II() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 2, 1 };
		final int[] nums2 = { 2, 2 };
		System.out.println(Arrays.toString(intersect(nums1, nums2)));

		final int[] nums3 = { 4, 9, 5 };
		final int[] nums4 = { 9, 4, 9, 8, 4 };
		System.out.println(Arrays.toString(intersect(nums3, nums4)));
	}

	static int[] intersect(int[] nums1, int[] nums2) {
		final int[] f1 = new int[1001];
		for (int num : nums1)
			f1[num] = f1[num] + 1;

		final int[] f2 = new int[1001];
		for (int num : nums2)
			f2[num] = f2[num] + 1;

		int n = 0;
		for (int i = 0; i <= 1000; i++)
			n = n + Math.min(f1[i], f2[i]);

		final int[] a = new int[n];
		for (int i = 0, curr = 0; i <= 1000; i++) {
			final int freq = Math.min(f1[i], f2[i]);
			for (int j = 0; j < freq; j++, curr++)
				a[curr] = i;
		}
		return a;
	}
}
