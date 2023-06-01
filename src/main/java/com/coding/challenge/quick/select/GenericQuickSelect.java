package com.coding.challenge.quick.select;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

public class GenericQuickSelect {
	GenericQuickSelect() {
		throw new AssertionError();
	}

	public static <T> T randomizedSelect(T[] a, int p, int r, int i, Comparator<? super T> cmp) {
		if (p == r)
			return a[p];
		final int q = randomizedPartition(a, p, r, cmp);
		final int k = q - p + 1;
		if (i == k)
			return a[q];
		else if (i < k)
			return randomizedSelect(a, p, q - 1, i, cmp);
		else
			return randomizedSelect(a, q + 1, r, i - k, cmp);
	}

	private static <T> int randomizedPartition(T[] a, int p, int r, Comparator<? super T> cmp) {
		final int i = ThreadLocalRandom.current().nextInt(p, r);
		exchange(a, i, r);
		return partition(a, p, r, cmp);
	}

	private static <T> int partition(T[] a, int p, int r, Comparator<? super T> cmp) {
		final T x = a[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (cmp.compare(a[j], x) <= 0) {
				i = i + 1;
				exchange(a, i, j);
			}
		}
		exchange(a, i + 1, r);
		return i + 1;
	}

	private static <T> void exchange(T[] a, int i, int j) {
		final T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
