package com.coding.challenge.bit.manipulation;

class MinimumNumberOfOperationsToMakeArrayXOREqualToK {
	MinimumNumberOfOperationsToMakeArrayXOREqualToK() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3, 4 };
		assert minOperations(nums1, 1) == 2;

		final int[] nums2 = { 2, 0, 2, 0 };
		assert minOperations(nums2, 0) == 0;
	}

	static int minOperations(int[] nums, int k) {
		int xor = 0;
		for (int v : nums)
			xor = xor ^ v;

		int flips = 0;
		for (int i = 0, curr = 1, b = (int) (Math.floor(Math.log(Math.max(k, xor)) / Math.log(2)) + 1); i < b; i++) {
			if ((curr & k) != (curr & xor))
				flips = flips + 1;
			curr = curr * 2;
		}

		return flips;
	}
}
