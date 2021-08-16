package com.coding.challenge.dp;

import com.coding.challenge.BinarySearch;

class LIS2 {

	private LIS2() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// LIS length = 4
//		final int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		// LIS length = 4
//		final int[] nums = { 0, 1, 0, 3, 2, 3 };
		// LIS length = 1
//		final int[] nums = { 7, 7, 7, 7, 7, 7, 7 };
		// LIS length = 5*
//		final int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18, 20 };
		// LIS length = 5
//		final int[] nums = { 10, 9, 2, 5, 3, 5, 7, 101, 18 };
		// LIS length = 6
//		final int[] nums = { 10, 9, 2, 5, 3, 5, 7, 101, 10, 18 };
		// LIS length = 5
//		final int[] nums = { 10, 9, 2, 5, 3, 5, 7, 101, 2, 18 };
		// LIS length = 7
//		final int[] nums = { 10, 9, 2, 5, 3, 5, 7, 101, 2, 18, 120, 150 };
		// LIS length = 8
//		final int[] nums = { 0, 1, 20, 21, 22, 2, 3, 4, 5, 6, 7 };
		// LIS length = 6
		final int[] nums = { 3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12 };
		final int lisLength = lengthOfLIS(nums);
		System.out.println(String.format("Length of LIS: %d", lisLength));
	}

	static int lengthOfLIS(int[] nums) {
		final int n = nums.length;
		final int[] a = new int[n];
		int l = 1;
		a[0] = nums[0];
		for (int i = 1; i < n; i++) {
			if (a[l - 1] < nums[i]) {
				a[l] = nums[i];
				l = l + 1;
			} else {
				final int j = BinarySearch.successor(a, nums[i], 0, l - 1);
				if (j == 0 || a[j - 1] != nums[i])
					a[j] = nums[i];
			}
		}
		return l;
	}
}
