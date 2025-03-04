package com.coding.challenge.two.pointer;

import java.util.Arrays;

class PartitionArrayAccordingToGivenPivot {
	PartitionArrayAccordingToGivenPivot() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 9, 12, 5, 10, 14, 3, 10 };
		final int[] a1 = { 9, 5, 3, 10, 10, 12, 14 };
		assert Arrays.equals(a1, pivotArray(nums1, 10));

		final int[] nums2 = { -3, 4, 3, 2 };
		final int[] a2 = { -3, 2, 4, 3 };
		assert Arrays.equals(a2, pivotArray(nums2, 2));
	}

	static int[] pivotArray(int[] nums, int pivot) {
		final int n = nums.length;
		final int[] a = new int[n];
		int i = 0;
		for (int k = 0; k < n; k++) {
			final int val = nums[k];
			if (val < pivot) {
				a[i] = val;
				i = i + 1;
			}
		}

		int j = n - 1;
		for (int k = n - 1; k >= 0; k--) {
			final int val = nums[k];
			if (val > pivot) {
				a[j] = val;
				j = j - 1;
			}
		}

		while (i <= j) {
			a[i] = pivot;
			i = i + 1;
		}

		return a;
	}
}
