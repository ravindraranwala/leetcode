package com.coding.challenge.dp;

class UncrossedLines {
	UncrossedLines() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 4, 2 };
		final int[] nums2 = { 1, 2, 4 };
		assert maxUncrossedLines(nums1, nums2) == 2;

		final int[] nums3 = { 2, 5, 1, 2, 5 };
		final int[] nums4 = { 10, 5, 2, 1, 5, 2 };
		assert maxUncrossedLines(nums3, nums4) == 3;

		final int[] nums5 = { 1, 3, 7, 1, 7, };
		final int[] nums6 = { 1, 9, 2, 5, 1 };
		assert maxUncrossedLines(nums5, nums6) == 2;
	}

	static int maxUncrossedLines(int[] nums1, int[] nums2) {
		final int m = nums1.length;
		final int n = nums2.length;
		final int[][] l = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (nums1[i - 1] == nums2[j - 1])
					l[i][j] = l[i - 1][j - 1] + 1;
				else
					l[i][j] = Math.max(l[i][j - 1], l[i - 1][j]);
			}
		}
		return l[m][n];
	}
}
