package com.coding.challenge.two.pointer;

import java.util.Arrays;

class SortColors {
	SortColors() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 0, 2, 1, 1, 0 };
		sortColors(nums1);
		final int[] expected1 = { 0, 0, 1, 1, 2, 2 };
		assert Arrays.equals(expected1, nums1);

		final int[] nums2 = { 2, 0, 1 };
		sortColors(nums2);
		final int[] expected2 = { 0, 1, 2 };
		assert Arrays.equals(expected2, nums2);

		final int[] nums3 = { 1, 2, 1, 2, 1, 1, 1 };
		sortColors(nums3);
		final int[] expected3 = { 1, 1, 1, 1, 1, 2, 2 };
		assert Arrays.equals(expected3, nums3);

		final int[] nums4 = { 2, 1, 2, 2, 2, 1, 2, 2, 2, 2 };
		sortColors(nums4);
		final int[] expected4 = { 1, 1, 2, 2, 2, 2, 2, 2, 2, 2 };
		assert Arrays.equals(expected4, nums4);

		final int[] nums5 = { 1, 1, 1, 1, 1, 1, 1 };
		sortColors(nums5);
		final int[] expected5 = { 1, 1, 1, 1, 1, 1, 1 };
		assert Arrays.equals(expected5, nums5);
	}

	static void sortColors(int[] nums) {
		final int n = nums.length;
		for (int k = 0, i = 0, j = 0; k < n; k++) {
			if (nums[k] == 1) {
				exchange(nums, k, j);
				j = j + 1;
			} else if (nums[k] == 0) {
				exchange(nums, k, j);
				exchange(nums, i, j);
				i = i + 1;
				j = j + 1;
			}
		}
	}

	private static void exchange(int[] nums, int i, int j) {
		final int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
