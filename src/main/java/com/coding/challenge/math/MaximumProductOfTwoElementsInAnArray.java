package com.coding.challenge.math;

class MaximumProductOfTwoElementsInAnArray {
	private static final int NEGATIVY_INFTY = -1001;

	MaximumProductOfTwoElementsInAnArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 3, 4, 5, };
		assert maxProduct(nums1) == 12;

		final int[] nums2 = { 1, 5, 4, 5 };
		assert maxProduct(nums2) == 16;

		final int[] nums3 = { 3, 7 };
		assert maxProduct(nums3) == 12;
	}

	static int maxProduct(int[] nums) {
		int largest = NEGATIVY_INFTY;
		int secondLargest = NEGATIVY_INFTY;

		for (int val : nums) {
			if (val > largest) {
				secondLargest = largest;
				largest = val;
			} else if (val > secondLargest)
				secondLargest = val;
		}

		return (largest - 1) * (secondLargest - 1);
	}
}
