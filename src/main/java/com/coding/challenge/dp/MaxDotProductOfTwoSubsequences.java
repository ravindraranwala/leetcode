package com.coding.challenge.dp;

class MaxDotProductOfTwoSubsequences {
	MaxDotProductOfTwoSubsequences() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 1, -2, 5 };
		final int[] nums2 = { 3, 0, -6 };
		assert maxDotProduct(nums1, nums2) == 18;

		final int[] nums3 = { 3, -2 };
		final int[] nums4 = { 2, -6, 7 };
		assert maxDotProduct(nums3, nums4) == 21;

		final int[] nums5 = { -1, -1 };
		final int[] nums6 = { 1, 1 };
		assert maxDotProduct(nums5, nums6) == -1;

		final int[] nums7 = { -1 };
		final int[] nums8 = { -2, -5 };
		assert maxDotProduct(nums7, nums8) == 5;

		final int[] nums9 = { -3, -7 };
		final int[] nums10 = { -2 };
		assert maxDotProduct(nums9, nums10) == 14;

		final int[] nums11 = { 1, -6 };
		final int[] nums12 = { -2, -4 };
		assert maxDotProduct(nums11, nums12) == 24;
	}

	static int maxDotProduct(int[] nums1, int[] nums2) {
		// init
		final int m = nums1.length;
		final int n = nums2.length;
		final int[][] p = new int[m + 1][n + 1];
		final int minVal = -1000000000;
		// trivial or base case of the recursion
		for (int i = 0; i <= m; i++)
			p[i][0] = minVal;

		for (int j = 1; j <= n; j++)
			p[0][j] = minVal;

		// non-trivial recursive step.
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++)
				p[i][j] = Math.max(Math.max(p[i - 1][j - 1] + nums1[i - 1] * nums2[j - 1], nums1[i - 1] * nums2[j - 1]),
						Math.max(p[i][j - 1], p[i - 1][j]));

		return p[m][n];
	}
}
