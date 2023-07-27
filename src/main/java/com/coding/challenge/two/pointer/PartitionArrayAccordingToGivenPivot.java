package com.coding.challenge.two.pointer;

import java.util.Arrays;

class PartitionArrayAccordingToGivenPivot {
	PartitionArrayAccordingToGivenPivot() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 9, 12, 5, 10, 14, 3, 10 };
		final int[] expectedOne = { 9, 5, 3, 10, 10, 12, 14 };
		assert Arrays.equals(expectedOne, pivotArray(numsOne, 10));

		final int[] numsTwo = { -3, 4, 3, 2 };
		final int[] expectedTwo = { -3, 2, 4, 3 };
		assert Arrays.equals(expectedTwo, pivotArray(numsTwo, 2));
	}

	static int[] pivotArray(int[] nums, int pivot) {
		final int n = nums.length;
		final int[] a = new int[n];
		int i = 0;
		for (int j = 0; j < n; j++) {
			if (nums[j] < pivot) {
				a[i] = nums[j];
				i = i + 1;
			}
		}

		for (int j = 0; j < n; j++) {
			if (nums[j] == pivot) {
				a[i] = nums[j];
				i = i + 1;
			}
		}

		for (int j = 0; j < n; j++) {
			if (nums[j] > pivot) {
				a[i] = nums[j];
				i = i + 1;
			}
		}
		return a;
	}
}
