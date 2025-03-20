package com.coding.challenge.greedy;

class WiggleSubsequence {
	WiggleSubsequence() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 7, 4, 9, 2, 5 };
		assert wiggleMaxLength(nums1) == 6;

		final int[] nums2 = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
		assert wiggleMaxLength(nums2) == 7;

		final int[] nums3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		assert wiggleMaxLength(nums3) == 2;

		final int[] nums4 = { 1, 1, 1, 1, 1, 1, 1 };
		assert wiggleMaxLength(nums4) == 1;

		final int[] nums5 = { 1, 2 };
		assert wiggleMaxLength(nums5) == 2;

		final int[] nums6 = { 7 };
		assert wiggleMaxLength(nums6) == 1;
	}

	static int wiggleMaxLength(int[] nums) {
		final int n = nums.length;
		int l = 0;
		boolean diffFound = false;
		for (int i = 1, d = 0; i < n; i++) {
			final int currDelta = nums[i] - nums[i - 1];
			if (currDelta != 0)
				diffFound = true;
			if (d > 0 && currDelta < 0)
				l = l + 1;
			else if (d < 0 && currDelta > 0)
				l = l + 1;

			if (currDelta != 0)
				d = currDelta;
		}
		return diffFound ? l + 2 : 1;
	}
}
