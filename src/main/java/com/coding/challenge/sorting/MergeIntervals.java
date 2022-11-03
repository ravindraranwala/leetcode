package com.coding.challenge.sorting;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class MergeIntervals {
	MergeIntervals() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] intervalsOne = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		final int[][] expOne = { { 1, 6 }, { 8, 10 }, { 15, 18 } };
		assert Arrays.deepEquals(expOne, merge(intervalsOne));

		final int[][] intervalsTwo = { { 1, 4 }, { 4, 5 } };
		final int[][] expTwo = { { 1, 5 } };
		assert Arrays.deepEquals(expTwo, merge(intervalsTwo));

		final int[][] intervalsThree = { { 1, 4 }, { 0, 4 } };
		final int[][] expThree = { { 0, 4 } };
		assert Arrays.deepEquals(expThree, merge(intervalsThree));
	}

	static int[][] merge(int[][] intervals) {
		/*
		 * use of a max-heap overkills, because all we need is just the interval with the
		 * most recent end date.
		 */
		final Deque<int[]> l = new LinkedList<>();
		// sort the events by their start date.
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		l.add(intervals[0]);

		/*
		 * loop-invariant: the interval at the tail of the linked list always contains
		 * the most recent end date so far.
		 */
		for (int[] interval : intervals) {
			final int[] e = l.getLast();
			// checking for overlapping intervals
			if (interval[0] > e[1])
				l.add(interval);
			else
				// merging intervals.
				e[1] = Math.max(interval[1], e[1]);

		}
		// constructing the output.
		return l.toArray(new int[0][0]);
	}
}
