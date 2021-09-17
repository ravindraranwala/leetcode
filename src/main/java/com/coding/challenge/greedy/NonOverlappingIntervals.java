package com.coding.challenge.greedy;

import java.util.Arrays;
import java.util.Comparator;

class NonOverlappingIntervals {

	NonOverlappingIntervals() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// Usecase 1.
		int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
		int e = eraseOverlapIntervals(intervals);
		System.out.println(e);

		// Usecase 2.
		int[][] intervals1 = { { 1, 2 }, { 1, 2 }, { 1, 2 } };
		e = eraseOverlapIntervals(intervals1);
		System.out.println(e);

		// Usecase 3.
		int[][] intervals2 = { { 1, 2 }, { 2, 3 } };
		e = eraseOverlapIntervals(intervals2);
		System.out.println(e);
	}

	static int eraseOverlapIntervals(int[][] intervals) {
		final int n = intervals.length;
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
		int c = 1;
		int k = 0;
		for (int i = 1; i < n; i++) {
			if (intervals[k][1] <= intervals[i][0]) {
				c = c + 1;
				k = i;
			}
		}
		return n - c;
	}
}
