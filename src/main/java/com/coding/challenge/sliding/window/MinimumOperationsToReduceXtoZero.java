package com.coding.challenge.sliding.window;

class MinimumOperationsToReduceXtoZero {
	MinimumOperationsToReduceXtoZero() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 1, 4, 2, 3 };
		assert minOperations(nums1, 5) == 2;

		final int[] nums2 = { 5, 6, 7, 8, 9 };
		assert minOperations(nums2, 4) == -1;

		final int[] nums3 = { 3, 2, 20, 1, 1, 3 };
		assert minOperations(nums3, 10) == 5;

		final int[] nums4 = { 1, 1 };
		assert minOperations(nums4, 3) == -1;

		assert minOperations(nums1, 11) == 5;
	}

	static int minOperations(int[] nums, int x) {
		final int n = nums.length;
		int s = 0;
		int maxLen = 0;
		for (int v : nums)
			s = s + v;

		if (s == x)
			return n;

		if (x > s)
			return -1;

		for (int i = 0, j = 0, windowSum = 0; j < n; j++) {
			windowSum = windowSum + nums[j];
			while (windowSum > s - x) {
				windowSum = windowSum - nums[i];
				i = i + 1;
			}
			if (windowSum == s - x)
				maxLen = Math.max(maxLen, j - i + 1);
		}

		return maxLen == 0 ? -1 : n - maxLen;
	}
}
