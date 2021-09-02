package com.coding.challenge.random;

import java.util.concurrent.ThreadLocalRandom;

class KthLargestElement {

	KthLargestElement() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums = { 3, 2, 1, 5, 6, 4 };
		int kth = findKthLargest(nums, 2);
		System.out.println(kth);

		final int[] nums2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		kth = findKthLargest(nums2, 4);
		System.out.println(kth);
	}

	static int findKthLargest(int[] nums, int k) {
		final int n = nums.length;
		final int ks = n - k + 1;
		return randomizedSelect(nums, 0, n - 1, ks);
	}

	static int randomizedSelect(int[] a, int p, int r, int i) {
		if (p == r)
			return a[p];
		final int q = randomizedPartition(a, p, r);
		final int k = q - p + 1;
		if (k == i)
			return a[q];
		else if (i < k)
			return randomizedSelect(a, p, q - 1, i);
		else
			return randomizedSelect(a, q + 1, r, i - k);
	}

	static int randomizedPartition(int[] a, int p, int r) {
		final int i = ThreadLocalRandom.current().nextInt(p, r + 1);
		final int tmp = a[i];
		a[i] = a[r];
		a[r] = tmp;
		return partition(a, p, r);
	}

	static int partition(int[] a, int p, int r) {
		final int x = a[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (a[j] <= x) {
				i = i + 1;
				final int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}
		final int tmp = a[i + 1];
		a[i + 1] = a[r];
		a[r] = tmp;
		return i + 1;
	}
}
