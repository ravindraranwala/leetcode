package com.coding.challenge.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Assert;

class MaxAttainableCourses {

	MaxAttainableCourses() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] courses1 = { { 100, 200 }, { 200, 1300 }, { 1000, 1250 }, { 2000, 3200 } };
		int n = scheduleCourse(courses1);
		System.out.println(n);

		final int[][] courses2 = { { 1, 2 } };
		n = scheduleCourse(courses2);
		System.out.println(n);

		final int[][] courses3 = { { 3, 2 }, { 4, 3 } };
		n = scheduleCourse(courses3);
		System.out.println(n);

		final int[][] courses4 = { { 5, 5 }, { 4, 6 }, { 2, 6 } };
		n = scheduleCourse(courses4);
		System.out.println(n);
		Assert.assertEquals(2, n);

		final int[][] courses5 = { { 7, 17 }, { 3, 12 }, { 10, 20 }, { 9, 10 }, { 5, 20 }, { 10, 19 }, { 4, 18 } };
		n = scheduleCourse(courses5);
		System.out.println(n);
		Assert.assertEquals(4, n);
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
