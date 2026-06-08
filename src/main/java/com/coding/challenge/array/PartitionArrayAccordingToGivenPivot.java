package com.coding.challenge.array;

import java.util.Arrays;

class PartitionArrayAccordingToGivenPivot {
	PartitionArrayAccordingToGivenPivot() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 9, 12, 5, 10, 14, 3, 10 };
		final int[] ans1 = { 9, 5, 3, 10, 10, 12, 14 };
		assert Arrays.equals(ans1, pivotArray(nums1, 10));

		final int[] nums2 = { -3, 4, 3, 2 };
		final int[] ans2 = { -3, 2, 4, 3 };
		assert Arrays.equals(ans2, pivotArray(nums2, 2));
	}

	static int[] pivotArray(int[] nums, int pivot) {
		final int n = nums.length;
		final int[] a = new int[n];
		int i = 0;
		for (int v : nums) {
			if (v < pivot) {
				a[i] = v;
				i = i + 1;
			}
		}

		for (int v : nums) {
			if (v == pivot) {
				a[i] = v;
				i = i + 1;
			}
		}

		for (int v : nums) {
			if (v > pivot) {
				a[i] = v;
				i = i + 1;
			}
		}
		return a;
	}
}
