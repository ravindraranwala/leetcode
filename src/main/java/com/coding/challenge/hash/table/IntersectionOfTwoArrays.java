package com.coding.challenge.hash.table;

import java.util.Arrays;

class IntersectionOfTwoArrays {
	IntersectionOfTwoArrays() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 2, 1 };
		final int[] nums2 = { 2, 2 };
		System.out.println(Arrays.toString(intersection(nums1, nums2)));
		
		final int[] nums3 = { 4, 9, 5 };
		final int[] nums4 = { 9, 4, 9, 8, 4 };
		System.out.println(Arrays.toString(intersection(nums3, nums4)));
	}

	static int[] intersection(int[] nums1, int[] nums2) {
		final boolean[] f1 = new boolean[1001];
		for (int num : nums1)
			f1[num] = true;

		final boolean[] f2 = new boolean[1001];
		for (int num : nums2)
			f2[num] = true;

		int n = 0;
		for (int i = 0; i <= 1000; i++)
			if (f1[i] && f2[i])
				n = n + 1;

		final int[] a = new int[n];
		for (int i = 0, curr = 0; i <= 1000; i++) {
			if (f1[i] && f2[i]) {
				a[curr] = i;
				curr = curr + 1;
			}
		}
		return a;
	}
}
