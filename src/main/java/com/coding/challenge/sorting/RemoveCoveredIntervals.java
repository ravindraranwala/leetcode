package com.coding.challenge.sorting;

import java.util.Arrays;
import java.util.Comparator;

class RemoveCoveredIntervals {
	RemoveCoveredIntervals() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] intervals1 = { { 1, 4 }, { 3, 6 }, { 2, 8 } };
		assert removeCoveredIntervals(intervals1) == 2;

		final int[][] intervals2 = { { 1, 4 }, { 2, 3 } };
		assert removeCoveredIntervals(intervals2) == 1;
	}

	static int removeCoveredIntervals(int[][] intervals) {
		final Comparator<int[]> cmp = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				final int ans = Integer.compare(o1[0], o2[0]);
				if (ans == 0)
					return Integer.compare(o2[1], o1[1]);

				return ans;
			}
		};

		Arrays.sort(intervals, cmp);
		int maxFin = 0;
		int remCnt = 0;
		for (int[] interval : intervals) {
			if (maxFin >= interval[1])
				remCnt = remCnt + 1;
			else
				maxFin = interval[1];
		}
		return intervals.length - remCnt;
	}
}
