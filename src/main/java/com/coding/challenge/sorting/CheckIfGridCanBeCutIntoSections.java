package com.coding.challenge.sorting;

import java.util.Arrays;

class CheckIfGridCanBeCutIntoSections {
	CheckIfGridCanBeCutIntoSections() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] rectangles1 = { { 1, 0, 5, 2 }, { 0, 2, 2, 4 }, { 3, 2, 5, 3 }, { 0, 4, 4, 5 } };
		assert checkValidCuts(5, rectangles1);

		final int[][] rectangles2 = { { 0, 0, 1, 1 }, { 2, 0, 3, 4 }, { 0, 2, 2, 3 }, { 3, 0, 4, 3 } };
		assert checkValidCuts(4, rectangles2);

		final int[][] rectangles3 = { { 0, 2, 2, 4 }, { 1, 0, 3, 2 }, { 2, 2, 3, 4 }, { 3, 0, 4, 2 }, { 3, 2, 4, 4 } };
		assert !checkValidCuts(4, rectangles3);
	}

	static boolean checkValidCuts(int n, int[][] rectangles) {
		Arrays.sort(rectangles, (a, b) -> Integer.compare(a[0], b[0]));
		final int verticalCuts = cuts(rectangles, 0);
		if (verticalCuts >= 2)
			return true;

		Arrays.sort(rectangles, (a, b) -> Integer.compare(a[1], b[1]));
		return cuts(rectangles, 1) >= 2;
	}

	private static int cuts(int[][] intervals, int startIdx) {
		final int n = intervals.length;
		int c = 0;
		for (int i = 0, f = intervals[0][startIdx + 2]; i < n; i++) {
			if (intervals[i][startIdx] >= f) {
				c = c + 1;
				f = intervals[i][startIdx + 2];
			} else
				f = Math.max(f, intervals[i][startIdx + 2]);
		}
		return c;
	}
}
