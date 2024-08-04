package com.coding.challenge.two.pointer;

import java.util.Arrays;

class NextPermutation {
	NextPermutation() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3 };
		nextPermutation(nums1);
		final int[] exp1 = { 1, 3, 2 };
		assert Arrays.equals(exp1, nums1);

		final int[] nums2 = { 3, 2, 1 };
		nextPermutation(nums2);
		final int[] exp2 = { 1, 2, 3 };
		assert Arrays.equals(exp2, nums2);

		final int[] nums3 = { 1, 1, 5 };
		nextPermutation(nums3);
		final int[] exp3 = { 1, 5, 1 };
		assert Arrays.equals(exp3, nums3);

		final int[] nums4 = { 5, 1, 1 };
		nextPermutation(nums4);
		final int[] exp4 = { 1, 1, 5 };
		assert Arrays.equals(exp4, nums4);

		final int[] nums5 = { 1, 3, 2 };
		nextPermutation(nums5);
		final int[] exp5 = { 2, 1, 3 };
		assert Arrays.equals(exp5, nums5);

		final int[] nums6 = { 2, 3, 1 };
		nextPermutation(nums6);
		final int[] exp6 = { 3, 1, 2 };
		assert Arrays.equals(exp6, nums6);

		final int[] nums7 = { 2, 1, 8, 3 };
		nextPermutation(nums7);
		final int[] exp7 = { 2, 3, 1, 8 };
		assert Arrays.equals(exp7, nums7);

		final int[] nums8 = { 5, 4, 7, 5, 3, 2 };
		nextPermutation(nums8);
		final int[] exp8 = { 5, 5, 2, 3, 4, 7 };
		assert Arrays.equals(exp8, nums8);
	}

	static void nextPermutation(int[] nums) {
		final int n = nums.length;
		int i = n - 2;
		while (i >= 0 && nums[i] >= nums[i + 1])
			i = i - 1;

		final int m = n - 1 - i;
		for (int j = 0; j < m / 2; j++)
			exchange(nums, i + j + 1, n - 1 - j);
		
		if (i >= 0) {
			int k = i + 1;
			while (nums[k] <= nums[i])
				k = k + 1;
			
			exchange(nums, i, k);
		}
	}

	private static void exchange(int[] a, int i, int j) {
		final int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
