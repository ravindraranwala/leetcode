package com.coding.challenge.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

class TheNumberOfTheSmallestUnoccupiedChair {
	TheNumberOfTheSmallestUnoccupiedChair() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] times1 = { { 1, 4 }, { 2, 3 }, { 4, 6 } };
		assert smallestChair(times1, 1) == 1;

		final int[][] times2 = { { 3, 10 }, { 1, 5 }, { 2, 6 } };
		assert smallestChair(times2, 0) == 2;

		final int[][] times3 = { { 33889, 98676 }, { 80071, 89737 }, { 44118, 52565 }, { 52992, 84310 },
				{ 78492, 88209 }, { 21695, 67063 }, { 84622, 95452 }, { 98048, 98856 }, { 98411, 99433 },
				{ 55333, 56548 }, { 65375, 88566 }, { 55011, 62821 }, { 48548, 48656 }, { 87396, 94825 },
				{ 55273, 81868 }, { 75629, 91467 } };
		assert smallestChair(times3, 6) == 2;
	}

	static int smallestChair(int[][] times, int targetFriend) {
		final int targetArrivalTime = times[targetFriend][0];
		Arrays.sort(times, (t1, t2) -> Integer.compare(t1[0], t2[0]));
		final PriorityQueue<Friend> friends = new PriorityQueue<>((f1, f2) -> Integer.compare(f1.leaving, f2.leaving));
		// sentinel
		friends.add(new Friend(Integer.MAX_VALUE, -1));
		final PriorityQueue<Integer> unoccupiedChairs = new PriorityQueue<>();
		final int n = times.length;
		unoccupiedChairs.add(n);

		for (int i = 0, c = 0; i < n; i++) {
			final int[] time = times[i];
			while (friends.peek().leaving <= time[0])
				// reclaim chairs
				unoccupiedChairs.add(friends.remove().chair);

			int currChair = c;
			if (unoccupiedChairs.peek() < c)
				currChair = unoccupiedChairs.remove();
			else
				c = c + 1;

			if (time[0] == targetArrivalTime)
				return currChair;
			friends.add(new Friend(time[1], currChair));
		}
		throw new AssertionError();
	}

	static class Friend {
		private final int leaving;
		private final int chair;

		Friend(int leaving, int chair) {
			this.leaving = leaving;
			this.chair = chair;
		}
	}
}
