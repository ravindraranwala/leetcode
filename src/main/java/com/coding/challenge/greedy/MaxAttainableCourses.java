package com.coding.challenge.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class MaxAttainableCourses {

	MaxAttainableCourses() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] courses1 = { { 100, 200 }, { 200, 1300 }, { 1000, 1250 }, { 2000, 3200 } };
		assert scheduleCourse(courses1) == 3;

		final int[][] courses2 = { { 1, 2 } };
		assert scheduleCourse(courses2) == 1;

		final int[][] courses3 = { { 3, 2 }, { 4, 3 } };
		assert scheduleCourse(courses3) == 0;

		final int[][] courses4 = { { 5, 5 }, { 4, 6 }, { 2, 6 } };
		assert scheduleCourse(courses4) == 2;

		final int[][] courses5 = { { 7, 17 }, { 3, 12 }, { 10, 20 }, { 9, 10 }, { 5, 20 }, { 10, 19 }, { 4, 18 } };
		assert scheduleCourse(courses5) == 4;
	}

	static int scheduleCourse(int[][] courses) {
		Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));
		final Queue<int[]> h = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

		int t = 0;
		int n = 0;
		for (int[] c : courses) {
			if (t + c[0] <= c[1]) {
				h.add(c);
				n = n + 1;
				t = t + c[0];
			} else {
				if (!h.isEmpty()) {
					// Get the course with the highest duration from the max heap h
					final int[] d = h.peek();
					/*
					 * if the current course has less duration than the max found, then check
					 * whether we can replace the max with the current course and find an optimal
					 * solution.
					 */
					if (c[0] < d[0] && t - d[0] + c[0] <= c[1]) {
						h.remove();
						h.add(c);
						t = t - d[0] + c[0];
						// count n remains unaffected
					}
				}
			}
		}
		return n;
	}
}
