package com.coding.challenge.dp;

class LargestSumOfAverages {
	LargestSumOfAverages() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 9, 1, 2, 3, 9 };
		System.out.println(largestSumOfAverages(nums1, 3));

		final int[] nums2 = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(largestSumOfAverages(nums2, 4));

		final int[] nums3 = { 4, 1, 7, 5, 6, 2, 3 };
		System.out.println(largestSumOfAverages(nums3, 4));
	}

	static double largestSumOfAverages(int[] nums, int k) {
		final int n = nums.length;
		final double[][] s = new double[k][n];
		// trivial case of the recursion.
		for (int i = 0, sum = 0; i < n; i++) {
			sum = sum + nums[i];
			s[0][i] = sum * 1.0 / (i + 1);
		}

		for (int p = 1; p < k; p++) {
			for (int i = p; i < n; i++) {
				for (int j = i, sum = 0; j >= p; j--) {
					sum = sum + nums[j];
					s[p][i] = Math.max(s[p][i], sum * 1.0 / (i - j + 1) + s[p - 1][j - 1]);
				}
			}
		}
		return s[k - 1][n - 1];
	}
}
