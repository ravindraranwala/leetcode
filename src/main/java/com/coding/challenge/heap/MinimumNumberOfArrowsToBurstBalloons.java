package com.coding.challenge.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class MinimumNumberOfArrowsToBurstBalloons {
	MinimumNumberOfArrowsToBurstBalloons() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] pointsOne = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
		assert findMinArrowShots(pointsOne) == 2;

		final int[][] pointsTwo = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };
		assert findMinArrowShots(pointsTwo) == 4;

		final int[][] pointsThree = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
		assert findMinArrowShots(pointsThree) == 2;
	}

	static int findMinArrowShots(int[][] points) {
		Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
		final Queue<int[]> h = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
		h.add(points[0]);
		for (int[] p1 : points) {
			final int[] p2 = h.peek();
			if (p2[1] >= p1[0]) {
				// coalesce overlapping intervals.
				h.poll();
				h.add(new int[] { Math.max(p1[0], p2[0]), Math.min(p1[1], p2[1]) });
			} else
				h.add(p1);
		}
		return h.size();
	}
}
