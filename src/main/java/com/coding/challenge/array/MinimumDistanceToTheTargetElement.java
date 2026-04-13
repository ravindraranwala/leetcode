package com.coding.challenge.array;

class MinimumDistanceToTheTargetElement {
	MinimumDistanceToTheTargetElement() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3, 4, 5 };
		assert getMinDistance(nums1, 5, 3) == 1;

		final int[] nums2 = { 1 };
		assert getMinDistance(nums2, 1, 0) == 0;

		final int[] nums3 = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		assert getMinDistance(nums3, 1, 0) == 0;
	}

	static int getMinDistance(int[] nums, int target, int start) {
		final int n = nums.length;
		int d = n;
		for (int i = 0; i < n; i++)
			if (nums[i] == target)
				d = Math.min(d, Math.abs(i - start));

		return d;
	}
}
