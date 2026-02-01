package com.coding.challenge.greedy;

class DivideAnArrayIntoSubarraysWithMinimumCostI {
	DivideAnArrayIntoSubarraysWithMinimumCostI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3, 12 };
		assert minimumCost(nums1) == 6;

		final int[] nums2 = { 5, 4, 3 };
		assert minimumCost(nums2) == 12;

		final int[] nums3 = { 10, 3, 1, 1 };
		assert minimumCost(nums3) == 12;
	}

	static int minimumCost(int[] nums) {
		final int n = nums.length;
		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++) {
			if (nums[i] < smallest) {
				secondSmallest = smallest;
				smallest = nums[i];
			} else if (nums[i] < secondSmallest)
				secondSmallest = nums[i];
		}
		return nums[0] + smallest + secondSmallest;
	}
}
