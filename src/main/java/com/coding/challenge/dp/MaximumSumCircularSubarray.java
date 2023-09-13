package com.coding.challenge.dp;

class MaximumSumCircularSubarray {
	MaximumSumCircularSubarray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, -2, 3, -2 };
		assert maxSubarraySumCircular(numsOne) == 3;

		final int[] numsTwo = { 5, -3, 5 };
		assert maxSubarraySumCircular(numsTwo) == 10;

		final int[] numsThree = { -3, -2, -3 };
		assert maxSubarraySumCircular(numsThree) == -2;

		final int[] numsFour = { 2, -2, 2, 7, 8, 0 };
		assert maxSubarraySumCircular(numsFour) == 19;
	}

	static int maxSubarraySumCircular(int[] nums) {
		final int n = nums.length;
		final int[] maxTailPreSum = new int[n];
		maxTailPreSum[n - 1] = nums[n - 1];
		for (int i = n - 2, tailPreSum = nums[n - 1]; i >= 0; i--) {
			tailPreSum = tailPreSum + nums[i];
			maxTailPreSum[i] = Math.max(tailPreSum, maxTailPreSum[i + 1]);
		}

		int maxCircularSubarraySum = Integer.MIN_VALUE;
		for (int i = 0, ps = 0; i < n - 1; i++) {
			ps = ps + nums[i];
			maxCircularSubarraySum = Math.max(maxCircularSubarraySum, ps + maxTailPreSum[i + 1]);
		}
		final int maxNonCircularSubarraySum = maxSubArray(nums);
		return Math.max(maxCircularSubarraySum, maxNonCircularSubarraySum);
	}

	static int maxSubArray(int[] nums) {
		final int n = nums.length;
		int maxSum = nums[0];
		for (int i = 1, s = nums[0]; i < n; i++) {
			if (nums[i] > s + nums[i])
				s = nums[i];
			else
				s = s + nums[i];
			maxSum = Math.max(maxSum, s);
		}
		return maxSum;
	}
}
