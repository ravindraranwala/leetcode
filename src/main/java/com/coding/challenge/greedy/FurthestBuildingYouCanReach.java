package com.coding.challenge.greedy;

import java.util.PriorityQueue;

class FurthestBuildingYouCanReach {
	FurthestBuildingYouCanReach() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] heights1 = { 4, 2, 7, 6, 9, 14, 12 };
		assert furthestBuilding(heights1, 5, 1) == 4;

		final int[] heights2 = { 4, 12, 2, 7, 3, 18, 20, 3, 19 };
		assert furthestBuilding(heights2, 10, 2) == 7;

		final int[] heights3 = { 14, 3, 19, 3 };
		assert furthestBuilding(heights3, 17, 0) == 3;

		final int[] heights4 = { 7, 5, 13 };
		assert furthestBuilding(heights4, 0, 0) == 1;

		final int[] heights5 = { 2, 7, 9, 12 };
		assert furthestBuilding(heights5, 5, 1) == 3;
	}

	static int furthestBuilding(int[] heights, int bricks, int ladders) {
		final int n = heights.length;
		final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 1, l = ladders, b = bricks; i < n && b >= 0; i++) {
			final int delta = heights[i] - heights[i - 1];
			if (delta > 0) {
				minHeap.add(delta);
				if (l > 0)
					l = l - 1;
				else if (b >= minHeap.peek())
					b = b - minHeap.remove();
				else
					return i - 1;
			}
		}
		return n - 1;
	}
}
