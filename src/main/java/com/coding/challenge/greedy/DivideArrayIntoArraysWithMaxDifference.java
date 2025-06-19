package com.coding.challenge.greedy;

import java.util.Arrays;

class DivideArrayIntoArraysWithMaxDifference {
	DivideArrayIntoArraysWithMaxDifference() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 3, 4, 8, 7, 9, 3, 5, 1 };
		final int[][] ans1 = { { 1, 1, 3 }, { 3, 4, 5 }, { 7, 8, 9 } };
		assert Arrays.deepEquals(ans1, divideArray(nums1, 2));

		final int[] nums2 = { 2, 4, 2, 2, 5, 2 };
		assert divideArray(nums2, 2).length == 0;

		final int[] nums3 = { 4, 2, 9, 8, 2, 12, 7, 12, 10, 5, 8, 5, 5, 7, 9, 2, 5, 11 };
		final int[][] ans2 = { { 2, 2, 2 }, { 4, 5, 5 }, { 5, 5, 7 }, { 7, 8, 8 }, { 9, 9, 10 }, { 11, 12, 12 } };
		assert Arrays.deepEquals(ans2, divideArray(nums3, 14));
	}

	static int[][] divideArray(int[] nums, int k) {
		final int n = nums.length;
		final int tripletsCnt = n / 3;
		final int[][] ans = new int[tripletsCnt][3];
		Arrays.sort(nums);
		for (int t = 0; t < tripletsCnt; t++) {
			final int start = 3 * t;
			if (nums[start + 2] - nums[start] > k)
				return new int[0][0];

			ans[t] = new int[] { nums[start], nums[start + 1], nums[start + 2] };
		}
		return ans;
	}
}
