package com.coding.challenge.two.pointer;

class MaximumDistanceBetweenPairOfValues {
	MaximumDistanceBetweenPairOfValues() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 55, 30, 5, 4, 2 };
		final int[] nums2 = { 100, 20, 10, 10, 5 };
		assert maxDistance(nums1, nums2) == 2;

		final int[] nums3 = { 2, 2, 2 };
		final int[] nums4 = { 10, 10, 1 };
		assert maxDistance(nums3, nums4) == 1;

		final int[] nums5 = { 30, 29, 19, 5 };
		final int[] nums6 = { 25, 25, 25, 25, 25 };
		assert maxDistance(nums5, nums6) == 2;
	}

	static int maxDistance(int[] nums1, int[] nums2) {
		final int m = nums1.length;
		final int n = nums2.length;
		int d = 0;
		for (int i = 0, j = 0; i < m && j < n; j++) {
			while (i < m && nums1[i] > nums2[j])
				i = i + 1;
			d = Math.max(d, j - i);
		}
		return d;
	}
}
