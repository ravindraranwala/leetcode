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

		final int[] nums3 = { 100, 4, 6 };
		assert !canPartition(nums3);

		final int[] nums4 = { 100 };
		assert !canPartition(nums4);

		final int[] nums5 = { 1, 5, 10, 6 };
		assert canPartition(nums5);
	}

	static boolean canPartition(int[] nums) {
		int s = 0;
		for (int val : nums)
			s = s + val;

		if (s % 2 == 1)
			return false;

		final int n = nums.length;
		final int sum = s / 2;
		final boolean[][] t = new boolean[sum + 1][n];

		// trivial case of the recursion.
		for (int i = 0; i < n; i++)
			t[0][i] = true;

		if (nums[0] <= sum)
			t[nums[0]][0] = true;

		for (int currSum = 1; currSum <= sum; currSum++) {
			for (int i = 1; i < n; i++) {
				t[currSum][i] = t[currSum][i - 1];
				if (currSum >= nums[i])
					t[currSum][i] = t[currSum][i] || t[currSum - nums[i]][i - 1];
			}
		}

		return t[sum][n - 1];
	}
}
