package com.coding.challenge.sliding.window;

class SubarrayProductLessThanK {
	SubarrayProductLessThanK() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 10, 5, 2, 6 };
		assert numSubarrayProductLessThanK(nums1, 100) == 8;

		final int[] nums2 = { 1, 2, 3 };
		assert numSubarrayProductLessThanK(nums2, 0) == 0;
	}

	static int numSubarrayProductLessThanK(int[] nums, int k) {
		final int n = nums.length;
		int c = 0;
		for (int i = 0, j = 0, p = 1; j < n; j++) {
			p = p * nums[j];
			while (i <= j && p >= k) {
				p = p / nums[i];
				i = i + 1;
			}
			// number of sub arrays finishing at index j, with product < k
			c = c + j - i + 1;
		}
		return c;
	}
}
