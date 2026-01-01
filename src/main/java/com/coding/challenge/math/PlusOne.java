package com.coding.challenge.math;

import java.util.Arrays;

class PlusOne {
	PlusOne() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] digits1 = { 1, 2, 3 };
		final int[] a1 = { 1, 2, 4 };
		assert Arrays.equals(a1, plusOne(digits1));

		final int[] digits2 = { 4, 3, 2, 1 };
		final int[] a2 = { 4, 3, 2, 2 };
		assert Arrays.equals(a2, plusOne(digits2));

		final int[] digits3 = { 9 };
		final int[] a3 = { 1, 0 };
		assert Arrays.equals(a3, plusOne(digits3));
	}

	static int[] plusOne(int[] digits) {
		final int n = digits.length;
		int nineCnt = 0;
		for (int v : digits)
			if (v == 9)
				nineCnt = nineCnt + 1;

		final int l = nineCnt == n ? n + 1 : n;
		final int[] a = new int[l];
		int cf = 1;
		for (int j = n - 1; j >= 0; j--) {
			final int val = digits[j] + cf;
			a[j] = val % 10;
			cf = val / 10;
		}

		if (cf == 1)
			a[0] = 1;

		return a;
	}
}
