package com.coding.challenge.prefix.sum;

class ValidSubarraysWithMatchingSumDigitsI {
	private static final char ZERO = '0';

	ValidSubarraysWithMatchingSumDigitsI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 100, 1 };
		assert countValidSubarrays(nums1, 1) == 4;

		final int[] nums2 = { 1 };
		assert countValidSubarrays(nums2, 2) == 0;
	}

	static int countValidSubarrays(int[] nums, int x) {
		final int n = nums.length;
		int cnt = 0;
		long preSum = 0;
		for (int i = 0; i < n; i++) {
			preSum = preSum + nums[i];
			long subArrSum = preSum;
			for (int j = 0; j <= i; j++) {
				if (String.valueOf(subArrSum).charAt(0) - ZERO == x && subArrSum % 10 == x)
					cnt = cnt + 1;

				subArrSum = subArrSum - nums[j];
			}
		}
		return cnt;
	}
}
