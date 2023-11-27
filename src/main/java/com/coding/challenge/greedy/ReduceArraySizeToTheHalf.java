package com.coding.challenge.greedy;

import java.util.Arrays;

class ReduceArraySizeToTheHalf {
	ReduceArraySizeToTheHalf() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arrOne = { 3, 3, 3, 3, 5, 5, 5, 2, 2, 7 };
		assert minSetSize(arrOne) == 2;

		final int[] arrTwo = { 7, 7, 7, 7, 7, 7 };
		assert minSetSize(arrTwo) == 1;
	}

	static int minSetSize(int[] arr) {
		final int[] f = new int[100001];
		for (int num : arr)
			f[num] = f[num] + 1;

		Arrays.sort(f);
		final int n = arr.length;
		int c = 0;
		int i = 100000;
		while (c < n / 2) {
			c = c + f[i];
			i = i - 1;
		}

		return 100000 - i;
	}
}
