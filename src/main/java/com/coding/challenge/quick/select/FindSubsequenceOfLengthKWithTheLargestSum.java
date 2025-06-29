package com.coding.challenge.quick.select;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

class FindSubsequenceOfLengthKWithTheLargestSum {
	FindSubsequenceOfLengthKWithTheLargestSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 1, 3, 3 };
		System.out.println(Arrays.toString(maxSubsequence(nums1, 2)));

		final int[] nums2 = { -1, -2, 3, 4 };
		System.out.println(Arrays.toString(maxSubsequence(nums2, 3)));

		final int[] nums3 = { 3, 4, 3, 3 };
		System.out.println(Arrays.toString(maxSubsequence(nums3, 2)));
	}

	static int[] maxSubsequence(int[] nums, int k) {
		final int n = nums.length;
		final int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = i;

		randomizedSelect(nums, a, 0, n - 1, nums.length - k + 1);
		final boolean[] output = new boolean[n];
		for (int j = n - k; j < n; j++)
			output[a[j]] = true;

		final int[] ans = new int[k];
		for (int p = 0, idx = 0; p < n; p++) {
			if (output[p]) {
				ans[idx] = nums[p];
				idx = idx + 1;
			}
		}
		return ans;
	}

	static int randomizedSelect(int[] nums, int[] a, int p, int r, int i) {
		if (p == r)
			return a[p];
		final int q = randomizedPartition(nums, a, p, r);
		final int k = q - p + 1;
		if (i == k)
			return a[q];
		else if (i < k)
			return randomizedSelect(nums, a, p, q - 1, i);
		else
			return randomizedSelect(nums, a, q + 1, r, i - k);
	}

	private static int randomizedPartition(int[] nums, int[] a, int p, int r) {
		final int i = ThreadLocalRandom.current().nextInt(p, r);
		exchange(a, i, r);
		return partition(nums, a, p, r);
	}

	private static int partition(int[] nums, int[] a, int p, int r) {
		final int x = nums[a[r]];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (nums[a[j]] <= x) {
				i = i + 1;
				exchange(a, i, j);
			}
		}
		exchange(a, i + 1, r);
		return i + 1;
	}

	private static void exchange(int[] a, int i, int j) {
		final int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
