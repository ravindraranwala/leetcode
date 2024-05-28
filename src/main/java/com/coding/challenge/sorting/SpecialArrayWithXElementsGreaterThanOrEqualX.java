package com.coding.challenge.sorting;

import java.util.Arrays;

class SpecialArrayWithXElementsGreaterThanOrEqualX {
	SpecialArrayWithXElementsGreaterThanOrEqualX() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 3, 5 };
		assert specialArray(nums1) == 2;

		final int[] nums2 = { 0, 0 };
		assert specialArray(nums2) == -1;

		final int[] nums3 = { 0, 4, 3, 0, 4 };
		assert specialArray(nums3) == 3;
	}

	static int specialArray(int[] nums) {
		final int n = nums.length;
		Arrays.sort(nums);

		for (int k = 1, i = 0; k <= n - i; k++) {
			while (k <= n - i && nums[i] < k)
				i = i + 1;
			if (k == n - i)
				return k;
		}
		return -1;
	}
}
