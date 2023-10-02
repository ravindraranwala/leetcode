package com.coding.challenge.two.pointer;

import java.util.Arrays;

class RearrangeArrayElementsBySign {
	RearrangeArrayElementsBySign() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 3, 1, -2, -5, 2, -4 };
		final int[] expectedOne = { 3, -2, 1, -5, 2, -4 };
		assert Arrays.equals(expectedOne, rearrangeArray(numsOne));

		final int[] numsTwo = { -1, 1 };
		final int[] expectedTwo = { 1, -1 };
		assert Arrays.equals(expectedTwo, rearrangeArray(numsTwo));
	}

	static int[] rearrangeArray(int[] nums) {
		final int n = nums.length;
		final int[] a = new int[n];

		for (int i = 0, positive = 0, negative = 1; i < n; i++) {
			if (nums[i] >= 0) {
				a[positive] = nums[i];
				positive = positive + 2;
			} else {
				a[negative] = nums[i];
				negative = negative + 2;
			}
		}
		return a;
	}
}
