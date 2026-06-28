package com.coding.challenge.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FilterOccupiedIntervals {
	FilterOccupiedIntervals() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] occupiedIntervals1 = { { 2, 6 }, { 4, 8 }, { 10, 10 }, { 10, 12 }, { 14, 16 } };
		final List<List<Integer>> ans1 = Arrays.asList(Arrays.asList(2, 6), Arrays.asList(12, 12),
				Arrays.asList(14, 16));
		assert ans1.equals(filterOccupiedIntervals(occupiedIntervals1, 7, 11));

		final int[][] occupiedIntervals2 = { { 1, 5 }, { 2, 3 } };
		assert Arrays.asList(Arrays.asList(1, 2)).equals(filterOccupiedIntervals(occupiedIntervals2, 3, 8));
	}

	static List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
		final int n = occupiedIntervals.length;
		Arrays.sort(occupiedIntervals, (a, b) -> Integer.compare(a[0], b[0]));
		// First merge the intervals.
		List<List<Integer>> mergedIntervals = new ArrayList<>();
		List<Integer> firstinterval = new ArrayList<>();
		firstinterval.add(occupiedIntervals[0][0]);
		firstinterval.add(occupiedIntervals[0][1]);
		mergedIntervals.add(firstinterval);

		for (int i = 1, l = 1; i < n; i++) {
			if (occupiedIntervals[i][0] - mergedIntervals.get(l - 1).get(1) > 1) {
				final List<Integer> list = new ArrayList<>();
				list.add(occupiedIntervals[i][0]);
				list.add(occupiedIntervals[i][1]);
				mergedIntervals.add(list);
				l = l + 1;
			} else {
				List<Integer> list = mergedIntervals.get(l - 1);
				list.set(1, Math.max(list.get(1), occupiedIntervals[i][1]));
			}
		}

		// Now, remove the time intervals overlap with the free interval.
		List<List<Integer>> l = new ArrayList<>();
		for (List<Integer> currInterval : mergedIntervals) {
			if (currInterval.get(1) < freeStart)
				l.add(currInterval);
			if (currInterval.get(0) > freeEnd)
				l.add(currInterval);
			if (currInterval.get(0) < freeStart && currInterval.get(1) >= freeStart)
				l.add(Arrays.asList(currInterval.get(0), freeStart - 1));
			if (currInterval.get(0) <= freeEnd && currInterval.get(1) > freeEnd)
				l.add(Arrays.asList(freeEnd + 1, currInterval.get(1)));
		}

		return l;
	}
}
