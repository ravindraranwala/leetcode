package com.coding.challenge.two.pointer;

class MinimumCommonValue {
	MinimumCommonValue() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3 };
		final int[] nums2 = { 2, 4 };
		assert getCommon(nums1, nums2) == 2;

		final int[] nums3 = { 1, 2, 3, 6 };
		final int[] nums4 = { 2, 3, 4, 5 };
		assert getCommon(nums3, nums4) == 2;
	}

	static int getCommon(int[] nums1, int[] nums2) {
		final int m = nums1.length;
		final int n = nums2.length;
		int i = 0;
		int j = 0;
		while (i < m && j < n) {
			if (nums1[i] == nums2[j])
				return nums1[i];
			else if (nums1[i] < nums2[j])
				i = i + 1;
			else
				j = j + 1;
		}
		return -1;
	}
}
