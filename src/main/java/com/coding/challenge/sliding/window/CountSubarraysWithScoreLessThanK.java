package com.coding.challenge.sliding.window;

class CountSubarraysWithScoreLessThanK {
	CountSubarraysWithScoreLessThanK() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 1, 4, 3, 5 };
		assert countSubarrays(nums1, 10) == 6;

		final int[] nums2 = { 1, 1, 1 };
		assert countSubarrays(nums2, 5) == 5;
	}

	static long countSubarrays(int[] nums, long k) {
		final int n = nums.length;
		long c = 0;
		long sum = 0;
		for (int i = 0, j = 0; j < n; j++) {
			sum = sum + nums[j];
			while (i <= j && sum * (j - i + 1) >= k) {
				sum = sum - nums[i];
				i = i + 1;
			}
			// number of sub arrays finishing at index j, with score < k
			c = c + j - i + 1;
		}
		return c;
	}
}
