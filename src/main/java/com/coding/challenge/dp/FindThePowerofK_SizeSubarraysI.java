package com.coding.challenge.dp;

import java.util.Arrays;

class FindThePowerofK_SizeSubarraysI {
	FindThePowerofK_SizeSubarraysI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3, 4, 3, 2, 5 };
		final int[] a1 = { 3, 4, -1, -1, -1 };
		assert Arrays.equals(a1, resultsArray(nums1, 3));

		final int[] nums2 = { 2, 2, 2, 2, 2 };
		final int[] a2 = { -1, -1 };
		assert Arrays.equals(a2, resultsArray(nums2, 4));

		final int[] nums3 = { 3, 2, 3, 2, 3, 2 };
		final int[] a3 = { -1, 3, -1, 3, -1 };
		assert Arrays.equals(a3, resultsArray(nums3, 2));

		final int[] nums4 = { 7 };
		final int[] a4 = { 7 };
		assert Arrays.equals(a4, resultsArray(nums4, 1));

		final int[] nums5 = { 1, 3, 4 };
		final int[] a5 = { -1, 4 };
		assert Arrays.equals(a5, resultsArray(nums5, 2));
	}

	static int[] resultsArray(int[] nums, int k) {
		final int n = nums.length;
		final int[] a = new int[n - k + 1];

		for (int i = 0, l = 0, prev = nums[0] - 1; i < n; i++) {
			if (nums[i] == prev + 1)
				l = l + 1;
			else
				l = 1;

			if (i >= k - 1) {
				final int j = i - k + 1;
				if (l >= k)
					a[j] = nums[i];
				else
					a[j] = -1;
			}
			prev = nums[i];
		}
		return a;
	}
}
