package com.coding.challenge.greedy;

class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {
	MinimumOperationsToMakeBinaryArrayElementsEqualToOneI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 0, 1, 1, 1, 0, 0 };
		assert minOperations(nums1) == 3;

		final int[] nums2 = { 0, 1, 1, 1 };
		assert minOperations(nums2) == -1;

		final int[] nums3 = { 1, 0, 0, 1, 1, 0, 1, 1, 1 };
		assert minOperations(nums3) == -1;
	}

	static int minOperations(int[] nums) {
		final int n = nums.length;
		int f = 0;
		for (int i = 0; i < n - 2; i++) {
			if (nums[i] == 0) {
				nums[i] = nums[i] ^ 1;
				nums[i + 1] = nums[i + 1] ^ 1;
				nums[i + 2] = nums[i + 2] ^ 1;
				f = f + 1;
			}
		}
		return nums[n - 2] == 1 && nums[n - 1] == 1 ? f : -1;
	}
}
