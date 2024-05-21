package com.coding.challenge.backtracking;

class SumOfAllSubsetXORTotals {
	private int xorSum = 0;

	SumOfAllSubsetXORTotals() {

	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 3 };
		assert new SumOfAllSubsetXORTotals().subsetXORSum(nums1) == 6;

		final int[] nums2 = { 5, 1, 6 };
		assert new SumOfAllSubsetXORTotals().subsetXORSum(nums2) == 28;

		final int[] nums3 = { 3, 4, 5, 6, 7, 8 };
		assert new SumOfAllSubsetXORTotals().subsetXORSum(nums3) == 480;
	}

	int subsetXORSum(int[] nums) {
		final int n = nums.length;
		for (int i = 0; i < n; i++)
			backtrack(nums, i, n, 0);
		return xorSum;
	}

	private void backtrack(int[] nums, int i, int n, int xor) {
		final int xorVal = xor ^ nums[i];
		xorSum = xorSum + xorVal;
		for (int j = i + 1; j < n; j++)
			backtrack(nums, j, n, xorVal);
	}
}
