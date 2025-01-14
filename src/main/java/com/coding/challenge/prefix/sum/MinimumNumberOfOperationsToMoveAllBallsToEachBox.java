package com.coding.challenge.prefix.sum;

import java.util.Arrays;

class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
	private static final char ZERO = '0';

	MinimumNumberOfOperationsToMoveAllBallsToEachBox() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] a1 = { 1, 1, 3 };
		assert Arrays.equals(a1, minOperations("110"));

		final int[] a2 = { 11, 8, 5, 4, 3, 4 };
		assert Arrays.equals(a2, minOperations("001011"));
	}

	static int[] minOperations(String boxes) {
		final int n = boxes.length();
		final int[] a = new int[n];
		for (int i = 0, ops = 0, ones = 0; i < n; i++) {
			ops = ops + ones;
			a[i] = ops;
			ones = ones + boxes.charAt(i) - ZERO;
		}

		for (int j = n - 1, ops = 0, ones = 0; j >= 0; j--) {
			ops = ops + ones;
			a[j] = a[j] + ops;
			ones = ones + boxes.charAt(j) - ZERO;
		}

		return a;
	}
}
