package com.coding.challenge.greedy;

class MaximumValueOfAnOrderedTripletI {
	MaximumValueOfAnOrderedTripletI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 12, 6, 1, 2, 7 };
		assert maximumTripletValueOptimized(nums1) == 77;

		final int[] nums2 = { 1, 10, 3, 4, 19 };
		assert maximumTripletValueOptimized(nums2) == 133;

		final int[] nums3 = { 1, 2, 3 };
		assert maximumTripletValueOptimized(nums3) == 0;

		final int[] nums4 = { 1000000, 1, 1000000 };
		assert maximumTripletValueOptimized(nums4) == 999999000000l;

		final int[] nums5 = { 12, 6, 1, 2, 16, 8, 1, 20 };
		assert maximumTripletValueOptimized(nums5) == 300;
	}

	static long maximumTripletValue(int[] nums) {
		final int n = nums.length;
		final int[] maxValAfter = new int[n];
		for (int i = n - 2; i >= 0; i--)
			maxValAfter[i] = Math.max(maxValAfter[i + 1], nums[i + 1]);

		long ans = 0;
		for (int j = 1, maxValBefore = nums[0]; j < n - 1; j++) {
			ans = Math.max(ans, (maxValBefore - nums[j]) * 1l * maxValAfter[j]);
			maxValBefore = Math.max(maxValBefore, nums[j]);
		}

		return ans;
	}

	static long maximumTripletValueOptimized(int[] nums) {
		final int n = nums.length;
		long ans = 0;
		for (int k = 0, maxDelta = 0, maxVal = 0; k < n; k++) {
			ans = Math.max(ans, maxDelta * 1l * nums[k]);
			maxDelta = Math.max(maxDelta, maxVal - nums[k]);
			maxVal = Math.max(maxVal, nums[k]);
		}
		return ans;
	}
}
