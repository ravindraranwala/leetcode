package com.coding.challenge.bit.manipulation;

import java.util.Arrays;
import java.util.List;

class ConstructTheMinimumBitwiseArrayI {
	ConstructTheMinimumBitwiseArrayI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final List<Integer> nums1 = Arrays.asList(2, 3, 5, 7);
		final int[] a1 = { -1, 1, 4, 3 };
		assert Arrays.equals(a1, minBitwiseArray(nums1));

		final List<Integer> nums2 = Arrays.asList(11, 13, 31);
		final int[] a2 = { 9, 12, 15 };
		assert Arrays.equals(a2, minBitwiseArray(nums2));
	}

	static int[] minBitwiseArray(List<Integer> nums) {
		final int n = nums.size();
		final int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			if ((nums.get(i) & 1) == 1) {
				int val = 1;
				int currNum = nums.get(i) >> 1;
				while ((currNum & 1) == 1) {
					currNum = currNum >> 1;
					val = val << 1;
				}

				a[i] = nums.get(i) - val;
			} else
				a[i] = -1;
		}
		return a;
	}
}
