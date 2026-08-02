package com.coding.challenge.dp;

class PredictTheWinner {
	PredictTheWinner() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 5, 2 };
		assert !predictTheWinner(nums1);

		final int[] nums2 = { 1, 5, 233, 7 };
		assert predictTheWinner(nums2);
	}

	static boolean predictTheWinner(int[] nums) {
		final int n = nums.length;
		final int[] preSum = new int[n + 1];
		final int[][] t = new int[n + 1][n + 1];
		// trivial or base case of the recursion.
		for (int i = 1, runningSum = 0; i <= n; i++) {
			t[i][i] = nums[i - 1];
			runningSum = runningSum + nums[i - 1];
			preSum[i] = runningSum;
		}

		// Non trivial, recursive step.
		for (int l = 2; l <= n; l++) {
			for (int i = 1; i <= n - l + 1; i++) {
				final int j = i + l - 1;
				t[i][j] = Math.max(nums[i - 1] + preSum[j] - preSum[i] - t[i + 1][j],
						nums[j - 1] + preSum[j - 1] - preSum[i - 1] - t[i][j - 1]);
			}
		}

		return t[1][n] >= preSum[n] - t[1][n];
	}
}
