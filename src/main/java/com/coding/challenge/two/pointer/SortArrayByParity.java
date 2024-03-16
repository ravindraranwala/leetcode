package com.coding.challenge.two.pointer;

import java.util.Arrays;

class SortArrayByParity {
	SortArrayByParity() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 3, 1, 2, 4 };
		System.out.println(Arrays.toString(sortArrayByParity(nums1)));

		final int[] nums2 = { 0 };
		System.out.println(Arrays.toString(sortArrayByParity(nums2)));
	}

	static int[] sortArrayByParity(int[] nums) {
		final int n = nums.length;
		// demarcates the partition having only even numbers from right.
		int i = -1;
		for (int j = 0; j < n; j++) {
			if (nums[j] % 2 == 0) {
				i = i + 1;
				// swap the two numbers.
				final int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		return nums;
	}
}
