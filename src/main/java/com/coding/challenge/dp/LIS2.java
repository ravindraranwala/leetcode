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
		final int[] m = new int[n];
		int l = 0;
		for (int i = 0; i < n; i++) {
			final int s = BinarySearch.successor(m, nums[i] - 1, 0, l - 1);
			if (s < l)
				m[s] = nums[i];
			else {
				m[l] = nums[i];
				l = l + 1;
			}
		}
		return l;
	}
}
