package com.coding.challenge.array;

import java.util.Arrays;

class BuildArrayFromPermutation {
	BuildArrayFromPermutation() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 0, 2, 1, 5, 3, 4 };
		final int[] a1 = { 0, 1, 2, 4, 5, 3 };
		assert Arrays.equals(a1, buildArray(nums1));

		final int[] nums2 = { 5, 0, 1, 2, 3, 4 };
		final int[] a2 = { 4, 5, 0, 1, 2, 3 };
		assert Arrays.equals(a2, buildArray(nums2));

		final int[] nums3 = { 3, 2, 1, 0 };
		final int[] a3 = { 0, 1, 2, 3 };
		assert Arrays.equals(a3, buildArray(nums3));
	}

	static int[] buildArrayInPlace(int[] nums) {
		final int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] < n) {
				final int initVal = nums[i];
				int j = i;
				while (nums[j] != i) {
					final int tmp = nums[j];
					// note the transformation function.
					nums[j] = nums[nums[j]] + n;
					j = tmp;
				}
				nums[j] = initVal + n;
			}
		}

		// use inverse function to undo the transformation.
		for (int i = 0; i < n; i++)
			nums[i] = nums[i] - n;

		return nums;
	}

	static int[] buildArray(int[] nums) {
		final int n = nums.length;
		for (int i = 0; i < n; i++)
			// transform or encode the value
			nums[i] = nums[nums[i]] % n * n + nums[i];

		// undo the transformation or decode the value.
		for (int i = 0; i < n; i++)
			nums[i] = nums[i] / n;
		return nums;
	}

	static int[] buildArrayTrivial(int[] nums) {
		final int n = nums.length;
		final int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nums[nums[i]];

		return a;
	}
}
