package com.coding.challenge.dp;

import java.util.Arrays;
import java.util.Comparator;

import com.coding.challenge.BinarySearch;

class WeightedActivityScheduling {

	WeightedActivityScheduling() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// usecase 1.
		final int[] s = { 1, 2, 3, 3 };
		final int[] f = { 3, 4, 5, 6 };
		final int[] v = { 50, 10, 40, 70 };
		int p = jobScheduling(s, f, v);
		System.out.println(p);

		// Usecase 2.
		final int[] s1 = { 1, 2, 3, 4, 6 };
		final int[] f1 = { 3, 5, 10, 6, 9 };
		final int[] v1 = { 20, 20, 100, 70, 60 };
		p = jobScheduling(s1, f1, v1);
		System.out.println(p);

		// Usecase 3.
		final int[] s2 = { 1, 1, 1 };
		final int[] f2 = { 2, 3, 4 };
		final int[] v2 = { 5, 6, 4 };
		p = jobScheduling(s2, f2, v2);
		System.out.println(p);
	}

	static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		final int n = startTime.length;
		final Activity[] a = new Activity[n];
		for (int i = 0; i < n; i++)
			a[i] = new Activity(startTime[i], endTime[i], profit[i]);
		Arrays.sort(a, Comparator.comparingInt(ac -> ac.f));
		for (int i = 0; i < n; i++) {
			startTime[i] = a[i].s;
			endTime[i] = a[i].f;
			profit[i] = a[i].v;
		}

		final int[] p = new int[n];
		int l = 0;
		p[0] = profit[0];
		for (int k = 1; k < n; k++) {
			if (endTime[l] <= startTime[k]) {
				p[k] = p[k - 1] + profit[k];
				l = k;
			} else {
				// Note that we need a closed interval here.
				final int c = BinarySearch.predecessor(endTime, startTime[k] + 1);
				int cv = 0;
				if (c > -1)
					cv = p[c];
				if (cv + profit[k] > p[k - 1]) {
					p[k] = cv + profit[k];
					l = k;
				} else
					p[k] = p[k - 1];
			}
		}
		return p[n - 1];
	}

	static class Activity {
		final int s;
		final int f;
		final int v;

		Activity(int s, int f, int v) {
			this.s = s;
			this.f = f;
			this.v = v;
		}
	}
}
