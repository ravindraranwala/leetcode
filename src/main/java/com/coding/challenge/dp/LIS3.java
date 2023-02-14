package com.coding.challenge.dp;

import com.coding.challenge.BinarySearch;

class LIS3 {
	LIS3() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS(numsOne));

		final int[] numsTwo = { 0, 1, 0, 3, 2, 3 };
		System.out.println(lengthOfLIS(numsTwo));

		final int[] numsThree = { 7, 7, 7, 7, 7, 7, 7 };
		System.out.println(lengthOfLIS(numsThree));
	}

	static int lengthOfLIS(int[] nums) {
		final int n = nums.length;
		final int[] s = new int[n];
		s[0] = nums[0];
		int l = 1;

		for (int i = 1; i < n; i++) {
			if (nums[i] > s[l - 1]) {
				s[l] = nums[i];
				l = l + 1;
			} else {
				final int j = BinarySearch.successor(s, nums[i] - 1, 0, l - 1);
				s[j] = nums[i];
			}
		}

		return l;
	}
}
