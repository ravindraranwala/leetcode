package com.coding.challenge.two.pointer;

import java.util.Arrays;

class MergeSortedArray {
	MergeSortedArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		final int[] nums2 = { 2, 5, 6 };
		merge(nums1, 3, nums2, 3);
		final int[] ans = { 1, 2, 2, 3, 5, 6 };
		assert Arrays.equals(ans, nums1);
	}

	static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m + n - 1;
		int j = m - 1;
		int k = n - 1;
		while (j >= 0 && k >= 0) {
			if (nums2[k] >= nums1[j]) {
				nums1[i] = nums2[k];
				k = k - 1;
				i = i - 1;
			} else {
				nums1[i] = nums1[j];
				j = j - 1;
				i = i - 1;
			}
		}

		while (k >= 0) {
			nums1[i] = nums2[k];
			k = k - 1;
			i = i - 1;
		}
	}
}
