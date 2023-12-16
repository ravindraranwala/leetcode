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

		final int[] nums7 = { -3, -8, 3, -10, 1, 3, 9 };
		final int[] nums8 = { 9, 2, 3, 7, -9, 1, -8, 5, -1, -1 };
		assert maxDotProduct(nums7, nums8) == 200;

	}

	static int maxDotProduct(int[] nums1, int[] nums2) {
		final int m = nums1.length;
		final int n = nums2.length;
		final int[][] dp = new int[m][n];
		dp[0][0] = nums1[0] * nums2[0];
		// trivial case of the recursion.
		for (int i = 1; i < m; i++)
			dp[i][0] = Math.max(dp[i - 1][0], nums1[i] * nums2[0]);

		// trivial case of the recursion.
		for (int j = 1; j < n; j++)
			dp[0][j] = Math.max(dp[0][j - 1], nums1[0] * nums2[j]);

		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				dp[i][j] = Math.max(Math.max(dp[i][j - 1], dp[i - 1][j]),
						Math.max(dp[i - 1][j - 1] + nums1[i] * nums2[j], nums1[i] * nums2[j]));

		return dp[m - 1][n - 1];
	}
}
