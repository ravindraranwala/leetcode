package com.coding.challenge.sliding.window;

class CountSubarraysWithFixedBounds {
	CountSubarraysWithFixedBounds() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 3, 5, 2, 7, 5 };
		assert countSubarrays(nums1, 1, 5) == 2;

		final int[] nums2 = { 1, 1, 1, 1 };
		assert countSubarrays(nums2, 1, 1) == 10;
	}

	static long countSubarrays(int[] nums, int minK, int maxK) {
		final int n = nums.length;
		long ans = 0;
		for (int i = 0, j = 0, x = -1, y = -1; j < n; j++) {
			final int currNum = nums[j];
			if (currNum >= minK && currNum <= maxK) {
				if (currNum == minK)
					x = j;
				if (currNum == maxK)
					y = j;
				if (x >= 0 && y >= 0)
					ans = ans + Math.min(x, y) - i + 1;
			} else {
				// init the empty window.
				i = j + 1;
				x = -1;
				y = -1;
			}
		}
		return ans;
	}
}
