package com.coding.challenge.dp;

import java.util.Arrays;

class LIS {
	private LIS() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		final int lisLength = lengthOfLIS(nums);
		System.out.println(String.format("Length of LIS: %d", lisLength));
	}

	public static int lengthOfLIS(int[] nums) {
		/*
		 * All we have to do is, sort the array while keeping only the distinct elements
		 * and then get the LCS between the original and distinct sorted
		 * sequences.Sorting takes (n log n) time and LCS takes n^2. So, overall it
		 * takes n^2 time.
		 */
		final int[] sortedNums = Arrays.copyOf(nums, nums.length);
		Arrays.sort(sortedNums);
		int[][] lcsLength = lcsLength(nums, sortedNums);
		return lcsLength[nums.length][sortedNums.length];
	}

	static int[][] lcsLength(int[] x, int[] y) {
		final int m = x.length;
		final int n = y.length;
		final int[][] c = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++)
			c[i][0] = 0;
		for (int j = 0; j <= n; j++)
			c[0][j] = 0;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x[i - 1] == y[j - 1] && (j < 2 || y[j - 2] != y[j - 1]))
					c[i][j] = c[i - 1][j - 1] + 1;
				else if (c[i - 1][j] >= c[i][j - 1])
					c[i][j] = c[i - 1][j];
				else
					c[i][j] = c[i][j - 1];
			}
		}
		return c;
	}
}
