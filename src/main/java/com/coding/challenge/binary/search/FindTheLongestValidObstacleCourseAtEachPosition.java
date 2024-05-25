package com.coding.challenge.binary.search;

import java.util.Arrays;

import com.coding.challenge.BinarySearch;

class FindTheLongestValidObstacleCourseAtEachPosition {
	FindTheLongestValidObstacleCourseAtEachPosition() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] obstacles1 = { 1, 2, 3, 2 };
		final int[] expected1 = { 1, 2, 3, 3 };
		assert Arrays.equals(expected1, longestObstacleCourseAtEachPosition(obstacles1));

		final int[] obstacles2 = { 2, 2, 1 };
		final int[] expected2 = { 1, 2, 1 };
		assert Arrays.equals(expected2, longestObstacleCourseAtEachPosition(obstacles2));

		final int[] obstacles3 = { 3, 1, 5, 6, 4, 2 };
		final int[] expected3 = { 1, 1, 2, 3, 2, 2 };
		assert Arrays.equals(expected3, longestObstacleCourseAtEachPosition(obstacles3));

		final int[] obstacles4 = { 5, 1, 5, 5, 1, 3, 4, 5, 1, 4 };
		final int[] expected4 = { 1, 1, 2, 3, 2, 3, 4, 5, 3, 5 };
		assert Arrays.equals(expected4, longestObstacleCourseAtEachPosition(obstacles4));
	}

	static int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
		final int n = obstacles.length;
		final int[] ans = new int[n];
		final int[] a = new int[n];
		ans[0] = 1;
		a[0] = obstacles[0];

		for (int i = 1, l = 0; i < n; i++) {
			final int j = BinarySearch.successor(a, obstacles[i], 0, l);
			ans[i] = j + 1;
			a[j] = obstacles[i];
			l = Math.max(l, j);
		}
		return ans;
	}
}
