package com.coding.challenge.dp;

class PartitionEqualSubsetSum {
	PartitionEqualSubsetSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 5, 11, 5 };
		assert canPartition(nums1);

		final int[] nums2 = { 1, 2, 3, 5 };
		assert !canPartition(nums2);
	}

	static boolean canPartition(int[] nums) {
		if (nums.length == 1)
			return false;
		int sum = 0;
		for (int val : nums)
			sum = sum + val;

		if (sum % 2 == 1)
			return false;
		final int s = sum / 2;
		final int n = nums.length;
		final boolean[][] t = new boolean[s + 1][n + 1];
		// trivial case of the recursion.
		for (int j = 0; j <= n; j++)
			t[0][j] = true;

		for (int i = 0; i <= s; i++) {
			for (int j = 1; j <= n; j++) {
				t[i][j] = t[i][j - 1];
				if (i - nums[j - 1] >= 0)
					t[i][j] = t[i][j] || t[i - nums[j - 1]][j - 1];
			}
		}
		return t[s][n];
	}
}
