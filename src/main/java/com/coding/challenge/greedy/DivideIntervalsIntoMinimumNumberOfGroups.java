package com.coding.challenge.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class DivideIntervalsIntoMinimumNumberOfGroups {
	DivideIntervalsIntoMinimumNumberOfGroups() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] intervalsOne = { { 5, 10 }, { 6, 8 }, { 1, 5 }, { 2, 3 }, { 1, 10 } };
		assert minGroups(intervalsOne) == 3;

		final int[][] intervalsTwo = { { 1, 3 }, { 5, 6 }, { 8, 10 }, { 11, 13 } };
		assert minGroups(intervalsTwo) == 1;

		final int[][] intervalsThree = { { 1, 10 }, { 2, 3 }, { 4, 8 }, { 5, 8 }, { 6, 7 } };
		assert minGroups(intervalsThree) == 4;
	}

	static int minGroups(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		final Queue<Integer> h = new PriorityQueue<>();
		h.add(0);
		for (int[] interval : intervals) {
			if (h.peek() < interval[0])
				h.remove();
			h.add(interval[1]);
		}
		return h.size();
	}
}
