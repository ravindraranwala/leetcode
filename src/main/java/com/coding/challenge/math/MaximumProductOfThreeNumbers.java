package com.coding.challenge.math;

class MaximumProductOfThreeNumbers {
	private static final int NEGATIVY_INFTY = -1001;
	private static final int INFTY = 1001;

	MaximumProductOfThreeNumbers() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3 };
		assert maximumProduct(nums1) == 6;

		final int[] nums2 = { 1, 2, 3, 4 };
		assert maximumProduct(nums2) == 24;

		final int[] nums3 = { -1, -2, -3 };
		assert maximumProduct(nums3) == -6;
	}

	static int maximumProduct(int[] nums) {
		int largest = NEGATIVY_INFTY;
		int secondLargest = NEGATIVY_INFTY;
		int thirdLargest = NEGATIVY_INFTY;
		int smallest = INFTY;
		int secondSmallest = INFTY;

		for (int val : nums) {
			if (val > largest) {
				thirdLargest = secondLargest;
				secondLargest = largest;
				largest = val;
			} else if (val > secondLargest) {
				thirdLargest = secondLargest;
				secondLargest = val;
			} else if (val > thirdLargest)
				thirdLargest = val;

			if (val < smallest) {
				secondSmallest = smallest;
				smallest = val;
			} else if (val < secondSmallest)
				secondSmallest = val;
		}
		return Math.max(largest * secondLargest * thirdLargest, largest * smallest * secondSmallest);
	}
}
