package com.coding.challenge.bit.manipulation;

import java.util.Arrays;

class MaximumXORforEachQuery {
	MaximumXORforEachQuery() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 0, 1, 1, 3 };
		final int[] ans1 = { 0, 3, 2, 3 };
		assert Arrays.equals(ans1, getMaximumXor(nums1, 2));

		final int[] nums2 = { 2, 3, 4, 7 };
		final int[] ans2 = { 5, 2, 6, 5 };
		assert Arrays.equals(ans2, getMaximumXor(nums2, 3));
	}

	static int[] getMaximumXor(int[] nums, int maximumBit) {
		int allOneVal = 1;
		for (int b = 2, curr = 1; b <= maximumBit; b++) {
			curr = curr * 2;
			allOneVal = allOneVal + curr;
		}

		final int n = nums.length;
		final int[] ans = new int[n];
		for (int i = 0, xorVal = 0; i < n; i++) {
			xorVal = xorVal ^ nums[i];
			ans[n - i - 1] = (xorVal & allOneVal) ^ allOneVal;
		}
		return ans;
	}
}
