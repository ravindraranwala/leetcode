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

//		final int maxProfit = maxSubArray(nums);
//		System.out.println(maxProfit);

		final int[] prices = { 7, 1, 5, 3, 6, 4 };
		final int profit = maxProfit(prices);
		System.out.println(profit);

		final int[] prices2 = { 7, 6, 4, 3, 1 };
		final int p = maxProfit(prices2);
		System.out.println(p);

		final int[] prices3 = { 1 };
		System.out.println(maxProfit(prices3));
	}

	static int maxSubArray(int[] nums) {
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

	/**
	 * Best Time to Buy and Sell Stock
	 * 
	 * @param prices price of a given stock on each day.
	 * @return the maximum profit you can achieve from this transaction. If you
	 *         cannot achieve any profit, return 0
	 */
	static int maxProfit(int[] prices) {
		int cf = 0;
		int profit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			final int delta = prices[i + 1] - prices[i];
			if (delta >= cf + delta)
				cf = delta;
			else
				cf += delta;

			if (profit < cf)
				profit = cf;
		}
		return profit;
	}
}
