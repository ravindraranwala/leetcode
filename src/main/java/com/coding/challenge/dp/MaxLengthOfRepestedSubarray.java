package com.coding.challenge.dp;

class MaxLengthOfRepestedSubarray {
	MaxLengthOfRepestedSubarray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 2, 3, 2, 1 };
		final int[] numsTwo = { 3, 2, 1, 4, 7 };
		assert findLength(numsOne, numsTwo) == 3;

		final int[] numsThree = { 0, 0, 0, 0, 0 };
		final int[] numsFour = { 0, 0, 0, 0, 0 };
		assert findLength(numsThree, numsFour) == 5;

		final int[] numsFive = { 1, 1, 1, 1, 5 };
		final int[] numsSix = { 1, 1, 1, 5 };
		assert findLength(numsFive, numsSix) == 4;
	}

	static int findLength(int[] nums1, int[] nums2) {
		final int m = nums1.length;
		final int n = nums2.length;
		int l = 0;
		// intialized to a default value of 0.
		final int[][] t = new int[m][n];

		// trivial case of the recursion.
		for (int i = 0; i < m; i++)
			t[i][n - 1] = nums1[i] == nums2[n - 1] ? 1 : 0;

		for (int j = 0; j < n; j++)
			t[m - 1][j] = nums1[m - 1] == nums2[j] ? 1 : 0;

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				if (nums1[i] == nums2[j])
					t[i][j] = t[i + 1][j + 1] + 1;

				l = Math.max(l, t[i][j]);
			}
		}

		return l;
	}
}
