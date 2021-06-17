package com.coding.challenge.dc;

public class MaxSubArr {
	private MaxSubArr() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		final int maxProfit = maxSubArray(nums);
		System.out.println(maxProfit);
//		System.out.println(maxCrossingSubArr(nums, 0, 4, 8));
	}

	public static int maxSubArray(int[] nums) {
		return findMaxSubArray(nums, 0, nums.length - 1);
	}

	static int findMaxSubArray(int[] nums, int low, int high) {
		if (nums.length == 0)
			throw new IllegalArgumentException("Empty array passed in.");
		// base case of the recursion.
		if (low == high)
			return nums[low];

		final int mid = (low + high) / 2;
		final int firstMax = findMaxSubArray(nums, low, mid);
		final int secondMax = findMaxSubArray(nums, mid + 1, high);
		final int crossingMax = maxCrossingSubArr(nums, low, mid, high);
		int max = Math.max(firstMax, secondMax);
		max = Math.max(max, crossingMax);
		return max;
	}

	static int maxCrossingSubArr(int[] nums, int low, int mid, int high) {
		int lMax = Integer.MIN_VALUE;
		int total = 0; // identity element for sum
		for (int i = mid; i >= low; i--) {
			total += nums[i];
			if (total >= lMax)
				lMax = total;
		}

		int rMax = Integer.MIN_VALUE;
		total = 0; // reset here.
		for (int j = mid + 1; j <= high; j++) {
			total += nums[j];
			if (total >= rMax)
				rMax = total;
		}
		return lMax + rMax;
	}
}
