package com.coding.challenge.two.pointer;

import java.util.Arrays;

class MinimizeMaxPairSum {
	MinimizeMaxPairSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 3, 5, 2, 3 };
		System.out.println(minPairSum(numsOne));

		final int[] numsTwo = { 3, 5, 4, 2, 4, 6 };
		System.out.println(minPairSum(numsTwo));
	}

	static int minPairSum(int[] nums) {
		final int n = nums.length;
		int ans = 0;
		Arrays.sort(nums);

		for (int i = 0; i < n / 2; i++)
			ans = Math.max(ans, nums[i] + nums[n - i - 1]);

		return ans;
	}
}
