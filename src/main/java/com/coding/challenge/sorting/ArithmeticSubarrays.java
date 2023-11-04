package com.coding.challenge.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ArithmeticSubarrays {
	ArithmeticSubarrays() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 4, 6, 5, 9, 3, 7 };
		final int[] l1 = { 0, 0, 2 };
		final int[] r1 = { 2, 3, 5 };
		assert Arrays.asList(true, false, true).equals(checkArithmeticSubarrays(nums1, l1, r1));

		final int[] nums2 = { -12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10 };
		final int[] l2 = { 0, 1, 6, 4, 8, 7 };
		final int[] r2 = { 4, 4, 9, 7, 9, 10 };
		assert Arrays.asList(false, true, false, false, true, true).equals(checkArithmeticSubarrays(nums2, l2, r2));
	}

	static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		final int m = l.length;
		final List<Boolean> result = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			final int left = l[i];
			final int right = r[i];
			final int size = right - left + 1;
			final int[] subArr = new int[size];
			for (int j = left; j <= right; j++)
				subArr[j - left] = nums[j];
			Arrays.sort(subArr);
			boolean arithmetic = true;
			for (int k = 1, d = subArr[1] - subArr[0]; k < size; k++)
				arithmetic = arithmetic && subArr[k] - subArr[k - 1] == d;
			result.add(arithmetic);
		}
		return result;
	}
}
