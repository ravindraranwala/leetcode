package com.coding.challenge.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class MeetingRoomsIII {
	MeetingRoomsIII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] meetings1 = { { 0, 10 }, { 1, 5 }, { 2, 7 }, { 3, 4 } };
		assert mostBooked(2, meetings1) == 0;

		final int[][] meetings2 = { { 1, 20 }, { 2, 10 }, { 3, 5 }, { 4, 9 }, { 6, 8 } };
		assert mostBooked(3, meetings2) == 1;
	}

	static int mostBooked(int n, int[][] meetings) {
		Arrays.sort(meetings, (m1, m2) -> Integer.compare(m1[0], m2[0]));
		final Queue<Room> occupied = new PriorityQueue<>((r1, r2) -> Long.compare(r1.finishTime, r2.finishTime));
		final Queue<Room> free = new PriorityQueue<>((r1, r2) -> Integer.compare(r1.id, r2.id));
		for (int i = 0; i < n; i++)
			free.add(new Room(i, -1));

		final int[] a = new int[n];
		for (int[] m : meetings) {
			final int start = m[0];
			while (!occupied.isEmpty() && occupied.peek().finishTime < start)
				free.add(occupied.poll());

			if (free.isEmpty()) {
				final long minFinish = occupied.peek().finishTime;
				while (!occupied.isEmpty() && occupied.peek().finishTime == minFinish)
					free.add(occupied.remove());
			}

			final Room r = free.remove();
			r.finishTime = Math.max(r.finishTime, start - 1) + m[1] - start;
			occupied.offer(r);
			a[r.id] = a[r.id] + 1;
		}

		int ans = 0;
		for (int j = 0; j < n; j++)
			if (a[j] > a[ans])
				ans = j;

		return ans;
	}

	static class Room {
		final int id;
		long finishTime;

		Room(int id, int finishTime) {
			this.id = id;
			this.finishTime = finishTime;
		}
	}
}
