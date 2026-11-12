package com.coding.challenge.array;

class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
	LongestStrictlyIncreasingOrStrictlyDecreasingSubarray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 4, 3, 3, 2 };
		assert longestMonotonicSubarray(nums1) == 2;

		final int[] nums2 = { 3, 3, 3, 3 };
		assert longestMonotonicSubarray(nums2) == 1;

		final int[] nums3 = { 3, 2, 1 };
		assert longestMonotonicSubarray(nums3) == 3;
	}

	static int longestMonotonicSubarray(int[] nums) {
		return Math.max(lengthOfLongestStrictlyIncreasingSubarray(nums),
				lengthOfLongestStrictlyDecreasingSubarray(nums));
	}

	private static int lengthOfLongestStrictlyIncreasingSubarray(int[] nums) {
		final int n = nums.length;
		int maxLen = 1;
		for (int i = 1, l = 1; i < n; i++) {
			if (nums[i] > nums[i - 1]) {
				l = l + 1;
			} else {
				l = 1;
			}
			maxLen = Math.max(maxLen, l);
		}
		return maxLen;
	}

	private static int lengthOfLongestStrictlyDecreasingSubarray(int[] nums) {
		final int n = nums.length;
		int maxLen = 1;
		for (int i = 1, l = 1; i < n; i++) {
			if (nums[i] < nums[i - 1]) {
				l = l + 1;
			} else {
				l = 1;
			}
			maxLen = Math.max(maxLen, l);
		}
		return maxLen;
	}
}
