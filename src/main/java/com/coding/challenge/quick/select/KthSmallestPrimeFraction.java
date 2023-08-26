package com.coding.challenge.quick.select;

import java.util.Arrays;

class KthSmallestPrimeFraction {
	KthSmallestPrimeFraction() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] p1 = { 1, 2, 3, 5 };
		assert Arrays.equals(new int[] { 2, 5 }, kthSmallestPrimeFraction(p1, 3));

		final int[] p2 = { 1, 7 };
		assert Arrays.equals(new int[] { 1, 7 }, kthSmallestPrimeFraction(p2, 1));
	}

	static int[] kthSmallestPrimeFraction(int[] arr, int k) {
		final int n = arr.length;
		final int l = n * (n - 1) / 2;
		final int[][] p = new int[l][2];
		for (int i = 0, idx = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				p[idx] = new int[] { arr[i], arr[j] };
				idx = idx + 1;
			}
		}

		return GenericQuickSelect.randomizedSelect(p, 0, l - 1, k,
				(a1, a2) -> Double.compare(a1[0] * 1.0 / a1[1], a2[0] * 1.0 / a2[1]));
	}
}
