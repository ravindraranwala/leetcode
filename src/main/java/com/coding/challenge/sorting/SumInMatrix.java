package com.coding.challenge.sorting;

import java.util.Arrays;

class SumInMatrix {
	SumInMatrix() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] nums1 = { { 7, 2, 1 }, { 6, 4, 2 }, { 6, 5, 3 }, { 3, 2, 1 } };
		assert matrixSum(nums1) == 15;
	}

	static int matrixSum(int[][] nums) {
		final int m = nums.length;
		final int n = nums[0].length;
		for (int[] row : nums)
			Arrays.sort(row);

		int s = 0;
		for (int j = 0; j < n; j++) {
			int max = 0;
			for (int i = 0; i < m; i++)
				max = Math.max(max, nums[i][j]);

			s = s + max;
		}
		return s;
	}
}
