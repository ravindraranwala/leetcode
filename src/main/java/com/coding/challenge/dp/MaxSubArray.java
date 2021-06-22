package com.coding.challenge.dp;

public class MaxSubArray {

	private MaxSubArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums = { -2, -1 };
//		final int[] nums = {-2,-1,-2};
//		final int[] nums = { 0, -3, -1, -2, -8, 1, 1, -5, -4 };
//		final int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
//		final int[] nums = { 1 };
//		final int[] nums = { 5, 4, -1, 7, 8 };

		final int maxProfit = maxSubArray(nums);
		System.out.println(maxProfit);
	}

	static int maxSubArray(int[] nums) {
		if (nums.length == 0)
			throw new IllegalArgumentException("Empty array passed in.");
		int cf = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= cf + nums[i])
				cf = nums[i];
			else
				cf += nums[i];
			
			if (maxSum < cf)
				maxSum = cf;
		}
		return maxSum;
	}
}
