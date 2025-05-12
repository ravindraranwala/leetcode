package com.coding.challenge.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Finding3DigitEvenNumbers {
	Finding3DigitEvenNumbers() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] digits1 = { 2, 1, 3, 0 };
		final int[] a1 = { 102, 120, 130, 132, 210, 230, 302, 310, 312, 320 };
		assert Arrays.equals(a1, findEvenNumbers(digits1));

		final int[] digits2 = { 2, 2, 8, 8, 2 };
		final int[] a2 = { 222, 228, 282, 288, 822, 828, 882 };
		assert Arrays.equals(a2, findEvenNumbers(digits2));

		final int[] digits3 = { 3, 7, 5 };
		final int[] a3 = {};
		assert Arrays.equals(a3, findEvenNumbers(digits3));
	}

	static int[] findEvenNumbers(int[] digits) {
		final List<Integer> l = new ArrayList<>();
		final int[] f = new int[10];
		for (int d : digits)
			f[d] = f[d] + 1;

		findNumber(f, 3, 0, l);
		final int n = l.size();
		final int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = l.get(i);

		return a;
	}

	private static void findNumber(int[] f, int n, int currVal, List<Integer> l) {
		if (n == 0) {
			if (currVal % 2 == 0)
				l.add(currVal);
			return;
		}

		final int start = n == 3 ? 1 : 0;
		for (int i = start; i < 10; i++) {
			if (f[i] > 0) {
				// choose.
				f[i] = f[i] - 1;
				// explore.
				findNumber(f, n - 1, currVal * 10 + i, l);
				// unchoose
				f[i] = f[i] + 1;
			}

		}
	}
}
