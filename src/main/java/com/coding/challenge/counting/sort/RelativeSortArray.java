package com.coding.challenge.counting.sort;

import java.util.Arrays;

class RelativeSortArray {
	RelativeSortArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
		final int[] arr2 = { 2, 1, 4, 3, 9, 6 };
		final int[] expected1 = { 2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19 };
		assert Arrays.equals(expected1, relativeSortArray(arr1, arr2));

		final int[] arr3 = { 28, 6, 22, 8, 44, 17 };
		final int[] arr4 = { 22, 28, 8, 6 };
		final int[] expected2 = { 22, 28, 8, 6, 17, 44 };
		assert Arrays.equals(expected2, relativeSortArray(arr3, arr4));
	}

	static int[] relativeSortArray(int[] arr1, int[] arr2) {
		final int[] f = new int[1001];
		for (int v : arr1)
			f[v] = f[v] + 1;

		final boolean[] elementOfArr2 = new boolean[1001];
		final int n = arr1.length;
		final int[] a = new int[n];
		int curr = 0;
		for (int e : arr2) {
			elementOfArr2[e] = true;
			final int freq = f[e];
			for (int i = 0; i < freq; i++) {
				a[curr] = e;
				curr = curr + 1;
			}
		}

		for (int i = 0; i <= 1000; i++) {
			if (!elementOfArr2[i]) {
				for (int j = 0; j < f[i]; j++) {
					a[curr] = i;
					curr = curr + 1;
				}
			}
		}
		return a;
	}
}
