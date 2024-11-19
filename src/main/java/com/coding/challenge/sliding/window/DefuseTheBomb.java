package com.coding.challenge.sliding.window;

import java.util.Arrays;

class DefuseTheBomb {
	DefuseTheBomb() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 5, 7, 1, 4 };
		final int[] a1 = { 12, 10, 16, 13 };
		assert Arrays.equals(a1, decrypt(nums1, 3));

		final int[] nums2 = { 1, 2, 3, 4 };
		final int[] a2 = { 0, 0, 0, 0 };
		assert Arrays.equals(a2, decrypt(nums2, 0));

		final int[] nums3 = { 2, 4, 9, 3 };
		final int[] a3 = { 12, 5, 6, 13 };
		assert Arrays.equals(a3, decrypt(nums3, -2));
	}

	static int[] decrypt(int[] code, int k) {
		if (k == 0)
			return new int[code.length];
		else if (k > 0)
			return next(code, k);
		else
			return prev(code, -k);
	}

	private static int[] next(int[] code, int k) {
		final int n = code.length;
		final int[] a = new int[n];

		for (int i = 0, s = 0; i < n + k; i++) {
			s = s + code[i % n];
			if (i >= k) {
				s = s - code[i - k];
				a[i - k] = s;
			}
		}
		return a;
	}

	private static int[] prev(int[] code, int k) {
		final int n = code.length;
		final int[] a = new int[n];

		for (int i = 0, s = 0; i < n + k; i++) {
			if (i >= k) {
				a[i % n] = s;
				s = s - code[i - k];
			}
			s = s + code[i % n];
		}
		return a;
	}
}
