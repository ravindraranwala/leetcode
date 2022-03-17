package com.coding.challenge.dp;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Assert;

class TwoBestNonOverlappingEvents {
	TwoBestNonOverlappingEvents() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] events1 = { { 1, 3, 2 }, { 4, 5, 2 }, { 2, 4, 3 } };
		int maxVal = maxTwoEvents(events1);
		System.out.println(maxVal);
		Assert.assertEquals(4, maxVal);

		final int[][] events2 = { { 1, 3, 2 }, { 4, 5, 2 }, { 1, 5, 5 } };
		maxVal = maxTwoEvents(events2);
		System.out.println(maxVal);
		Assert.assertEquals(5, maxVal);

		final int[][] events3 = { { 1, 5, 3 }, { 1, 5, 1 }, { 6, 6, 5 } };
		maxVal = maxTwoEvents(events3);
		System.out.println(maxVal);
		Assert.assertEquals(8, maxVal);

		final int[][] events4 = { { 66, 97, 90 }, { 98, 98, 68 }, { 38, 49, 63 }, { 91, 100, 42 }, { 92, 100, 22 },
				{ 1, 77, 50 }, { 64, 72, 97 } };
		maxVal = maxTwoEvents(events4);
		Assert.assertEquals(165, maxVal);
		System.out.println(maxVal);
	}

	static int maxTwoEvents(int[][] events) {
		Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
		final PriorityQueue<int[]> h = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
		int maxVal = 0;
		int ans = 0;
		for (int[] e : events) {
			while (!h.isEmpty() && h.peek()[1] < e[0]) {
				final int[] nonOverlappingEvnt = h.remove();
				maxVal = Math.max(maxVal, nonOverlappingEvnt[2]);
			}
			ans = Math.max(ans, maxVal + e[2]);
			h.add(e);
		}
		return ans;
	}
}
