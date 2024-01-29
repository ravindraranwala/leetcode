package com.coding.challenge.array.util;

public class ArrayUtils {
	/**
	 * Reverses the input array in place.
	 * 
	 * @param a sequence of integers.
	 */
	public static void reverse(int[] a) {
		final int n = a.length;
		for (int i = 0; i < n / 2; i++) {
			final int tmp = a[i];
			a[i] = a[n - i - 1];
			a[n - i - 1] = tmp;
		}
	}
}
