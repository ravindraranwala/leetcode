package com.coding.challenge.quick.select;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

class WiggleSort {
	WiggleSort() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
//		final int[] numsOne = { 1, 5, 1, 1, 6, 4 };
//		wiggleSort(numsOne);
//		System.out.println(Arrays.toString(numsOne));

//		final int[] numsTwo = { 1, 3, 2, 2, 3, 1 };
//		wiggleSort(numsTwo);
//		System.out.println(Arrays.toString(numsTwo));

//		final int[] numsThree = { 1, 1, 2, 1, 2, 2, 1 };
//		wiggleSort(numsThree);
//		System.out.println(Arrays.toString(numsThree));

//		final int[] numsFour = { 1, 2, 2, 1, 2, 1, 1, 1, 1, 2, 2, 2 };
//		wiggleSort(numsFour);
//		System.out.println(Arrays.toString(numsFour));

//		final int[] numsFive = { 2, 1 };
//		wiggleSort(numsFive);
//		System.out.println(Arrays.toString(numsFive));

//		final int[] numsSix = { 1, 4, 3, 4, 1, 2, 1, 3, 1, 3, 2, 3, 3 };
//		wiggleSort(numsSix);
//		System.out.println(Arrays.toString(numsSix));

//		final int[] numsSeven = { 2 };
//		wiggleSort(numsSeven);
//		System.out.println(Arrays.toString(numsSeven));

		final int[] numsEight = { 4, 5, 5, 6 };
		wiggleSort(numsEight);
		System.out.println(Arrays.toString(numsEight));
	}

	static void wiggleSort(int[] nums) {
		throw new UnsupportedOperationException();
	}

	static int randomizedSelect(int[] a, int p, int r, int i) {
		if (p == r)
			return a[p];
		final int q = randomizedPartition(a, 0, r);
		final int k = q - p + 1;
		if (i == k)
			return a[q];
		else if (i < k)
			return randomizedSelect(a, p, q - 1, i);
		else
			return randomizedSelect(a, q + 1, r, i - k);
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

	static int randomizedPartition(int[] a, int p, int r) {
		final int i = ThreadLocalRandom.current().nextInt(p, r + 1);
		final int tmp = a[i];
		a[i] = a[r];
		a[r] = tmp;
		return partition(a, p, r);
	}
}
