package com.coding.challenge.sorting;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class InsertInterval {
	InsertInterval() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] intervalsOne = { { 1, 3 }, { 6, 9 } };
		final int[] newIntervalsOne = { 2, 5 };
		final int[][] expOne = { { 1, 5 }, { 6, 9 } };
		assert Arrays.deepEquals(expOne, insert(intervalsOne, newIntervalsOne));

		final int[][] intervalsTwo = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		final int[] newIntervalsTwo = { 4, 8 };
		final int[][] expTwo = { { 1, 2 }, { 3, 10 }, { 12, 16 } };
		assert Arrays.deepEquals(expTwo, insert(intervalsTwo, newIntervalsTwo));

		final int[] newIntervalsThree = { 5, 7 };
		assert Arrays.deepEquals(new int[][] { newIntervalsThree }, insert(new int[0][0], newIntervalsThree));

		final int[][] intervalsFour = { { 1, 5 } };
		final int[] newIntervalFour = { 6, 8 };
		final int[][] expFour = { { 1, 5 }, { 6, 8 } };
		assert Arrays.deepEquals(expFour, insert(intervalsFour, newIntervalFour));
	}

	static int[][] insert(int[][] intervals, int[] newInterval) {
		final int n = intervals.length;
		final int[][] allIntervals = new int[n + 1][2];
		int k = 0;
		while (k < n && intervals[k][0] < newInterval[0]) {
			allIntervals[k] = intervals[k];
			k = k + 1;
		}

		allIntervals[k] = newInterval;
		while (k < n) {
			allIntervals[k + 1] = intervals[k];
			k = k + 1;
		}

		final Deque<int[]> l = new LinkedList<>();
		l.add(allIntervals[0]);

		for (int[] interval : allIntervals) {
			final int[] e = l.getLast();
			// checking for overlapping intervals
			if (e[1] < interval[0])
				l.add(interval);
			else
				// merge intervals if required
				e[1] = Math.max(e[1], interval[1]);
		}

		// constructing the output.
		return l.toArray(new int[0][0]);
	}
}
