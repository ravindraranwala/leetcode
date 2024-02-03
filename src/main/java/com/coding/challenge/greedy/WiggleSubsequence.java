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

		final int[] nums4 = { 84 };
		assert wiggleMaxLength(nums4) == 1;
	}

	static int wiggleMaxLength(int[] nums) {
		// option 1.
		final int l1 = wiggleLength(nums, false);
		// option 2.
		final int l2 = wiggleLength(nums, true);
		return Math.max(l1, l2);
	}

	private static int wiggleLength(int[] nums, boolean increasing) {
		final int n = nums.length;
		boolean inc = increasing;
		int l = 1;
		for (int i = 1; i < n; i++) {
			if (inc && nums[i] < nums[i - 1]) {
				l = l + 1;
				inc = false;
			} else if (!inc && nums[i] > nums[i - 1]) {
				l = l + 1;
				inc = true;
			}
		}
		return l;
	}
}
