package com.coding.challenge.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class MaxEventsAttended {
	MaxEventsAttended() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] events = { { 27, 27 }, { 8, 10 }, { 9, 11 }, { 20, 21 }, { 25, 29 }, { 17, 20 }, { 12, 12 },
				{ 12, 12 }, { 10, 14 }, { 7, 7 }, { 6, 10 }, { 7, 7 }, { 4, 8 }, { 30, 31 }, { 23, 25 }, { 4, 6 },
				{ 17, 17 }, { 13, 14 }, { 6, 9 }, { 13, 14 } };
		assert maxEvents(events) == 18;

		final int[][] events2 = { { 1, 2 }, { 1, 2 }, { 3, 3 }, { 1, 5 }, { 1, 5 } };
		assert maxEvents(events2) == 5;

		final int[][] events3 = { { 1, 5 }, { 1, 5 }, { 1, 5 }, { 2, 3 }, { 2, 3 } };
		assert maxEvents(events3) == 5;
	}

	static int maxEvents(int[][] events) {
		final int n = events.length;
		final Queue<Integer> h = new PriorityQueue<>(Integer::compare);
		Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
		int c = 0;
		int s = events[0][0];
		int e = 0;
		int p = 0;
		for (int[] evnt : events)
			e = Math.max(e, evnt[1]);
		for (int d = s; d <= e; d++) {
			while (!h.isEmpty() && h.peek() < d)
				h.remove();

			while (p < n && events[p][0] == d) {
				h.add(events[p][1]);
				p = p + 1;
			}

			// then try to attend the event.
			if (!h.isEmpty()) {
				h.remove();
				c = c + 1;
			}
		}
		return c;
	}
}
