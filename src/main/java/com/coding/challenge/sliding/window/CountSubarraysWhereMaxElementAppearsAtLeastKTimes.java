package com.coding.challenge.sliding.window;

class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
	CountSubarraysWhereMaxElementAppearsAtLeastKTimes() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 3, 2, 3, 3 };
		assert countSubarrays(nums1, 2) == 6;

		final int[] nums2 = { 1, 4, 2, 1 };
		assert countSubarrays(nums2, 3) == 0;
	}

	static long countSubarrays(int[] nums, int k) {
		final int n = nums.length;
		int maxElt = 0;
		// find the max value first.
		for (int i = 0; i < n; i++)
			maxElt = Math.max(maxElt, nums[i]);

		long c = 0;
		for (int s = 0, e = 0, f = 0; e < n; e++) {
			if (nums[e] == maxElt)
				f = f + 1;

			// count sub arrays finishing at e if any.
			while (f == k) {
				if (nums[s] == maxElt)
					f = f - 1;
				s = s + 1;
			}
			c = c + s;
		}
		return c;
	}
}
