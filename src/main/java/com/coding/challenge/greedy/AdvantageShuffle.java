package com.coding.challenge.greedy;

import java.util.Arrays;

class AdvantageShuffle {
	AdvantageShuffle() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 2, 7, 11, 15 };
		final int[] numstwo = { 1, 10, 4, 11 };
		final int[] expectedOne = { 2, 11, 7, 15 };
		assert Arrays.equals(expectedOne, advantageCount(numsOne, numstwo));

		final int[] numsThree = { 12, 24, 8, 32 };
		final int[] numsFour = { 13, 25, 32, 11 };
		final int[] expectedThree = { 24, 32, 8, 12 };
		assert Arrays.equals(expectedThree, advantageCount(numsThree, numsFour));
	}

	static int[] advantageCount(int[] nums1, int[] nums2) {
		final int n = nums1.length;
		final int[] p = new int[n];
		final int[][] a = new int[n][2];
		for (int i = 0; i < n; i++)
			a[i] = new int[] { i, nums2[i] };

		Arrays.sort(nums1);
		Arrays.sort(a, (b, c) -> Integer.compare(b[1], c[1]));
		// Two pointer solution.
		for (int i = n - 1, j = n - 1, k = 0; j >= 0; j--) {
			final int idx = a[j][0];
			if (nums1[i] > a[j][1]) {
				p[idx] = nums1[i];
				i = i - 1;
			} else {
				p[idx] = nums1[k];
				k = k + 1;
			}
		}
		return p;
	}
}
