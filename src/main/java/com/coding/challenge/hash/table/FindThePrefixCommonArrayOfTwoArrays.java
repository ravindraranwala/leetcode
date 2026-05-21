package com.coding.challenge.hash.table;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class FindThePrefixCommonArrayOfTwoArrays {
	FindThePrefixCommonArrayOfTwoArrays() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 3, 2, 4 };
		final int[] nums2 = { 3, 1, 2, 4 };
		final int[] a1 = { 0, 2, 3, 4 };
		assert Arrays.equals(a1, findThePrefixCommonArray(nums1, nums2));

		final int[] nums3 = { 2, 3, 1 };
		final int[] nums4 = { 3, 1, 2 };
		final int[] a2 = { 0, 1, 3 };
		assert Arrays.equals(a2, findThePrefixCommonArray(nums3, nums4));
	}

	static int[] findThePrefixCommonArray(int[] A, int[] B) {
		final int n = A.length;
		final int[] c = new int[n];
		final Set<Integer> s1 = new HashSet<>();
		final Set<Integer> s2 = new HashSet<>();
		final Set<Integer> intersect = new HashSet<>();

		for (int i = 0; i < n; i++) {
			s1.add(A[i]);
			s2.add(B[i]);
			if (!intersect.contains(A[i]) && s2.contains(A[i]))
				intersect.add(A[i]);
			if (!intersect.contains(B[i]) && s1.contains(B[i]))
				intersect.add(B[i]);

			c[i] = intersect.size();
		}
		return c;
	}
}
