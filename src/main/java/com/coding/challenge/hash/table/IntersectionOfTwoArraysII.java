package com.coding.challenge.hash.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IntersectionOfTwoArraysII {
	IntersectionOfTwoArraysII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 2, 1 };
		final int[] nums2 = { 2, 2 };
		System.out.println(Arrays.toString(intersect(nums1, nums2)));
	}

	static int[] intersect(int[] nums1, int[] nums2) {
		final int[] f = new int[1001];
		for (int num : nums1)
			f[num] = f[num] + 1;

		final List<Integer> ans = new ArrayList<>();
		for (int num : nums2) {
			if (f[num] > 0) {
				ans.add(num);
				f[num] = f[num] - 1;
			}
		}

		final int n = ans.size();
		final int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ans.get(i);

		return a;
	}
}
