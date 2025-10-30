package com.coding.challenge.prefix.sum;

class MakeArrayElementsEqualToZero {
	MakeArrayElementsEqualToZero() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 0, 2, 0, 3 };
		assert countValidSelections(nums1) == 2;

		final int[] nums2 = { 2, 3, 4, 0, 4, 1, 0 };
		assert countValidSelections(nums2) == 0;
	}

	static int countValidSelections(int[] nums) {
		final int n = nums.length;
		int sum = 0;

		for (int j = 0; j < n; j++)
			sum = sum + nums[j];

		int selections = 0;
		for (int i = 0, prefixSum = 0; i < n; i++) {
			final int postfixSum = sum - prefixSum - nums[i];
			if (nums[i] == 0) {
				final int delta = Math.abs(prefixSum - postfixSum);
				if (delta == 1)
					selections = selections + 1;
				else if (delta == 0)
					selections = selections + 2;
			}
			prefixSum = prefixSum + nums[i];
		}
		return selections;
	}
}
