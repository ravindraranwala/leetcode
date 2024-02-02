package com.coding.challenge.dp;

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
	}

	static int wiggleMaxLength(int[] nums) {
		final int n = nums.length;
		final int[] lastIncLen = new int[n];
		final int[] lastDecLen = new int[n];
		lastIncLen[0] = 1;
		lastDecLen[0] = 1;
		int maxLen = 1;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j])
					lastIncLen[i] = Math.max(lastIncLen[i], lastDecLen[j] + 1);
				else if (nums[i] < nums[j])
					lastDecLen[i] = Math.max(lastDecLen[i], lastIncLen[j] + 1);
			}
			maxLen = Math.max(maxLen, Math.max(lastIncLen[i], lastDecLen[i]));
		}
		return maxLen;
	}
}
