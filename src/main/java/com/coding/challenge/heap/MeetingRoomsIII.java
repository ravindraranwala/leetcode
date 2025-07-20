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
		assert mostBooked(2, meetings2) == 1;
	}

	static int mostBooked(int n, int[][] meetings) {
		final Queue<Room> free = new PriorityQueue<>((r1, r2) -> Integer.compare(r1.number, r2.number));
		for (int r = 0; r < n; r++)
			free.add(new Room(r, 0));

		final Queue<Room> occupied = new PriorityQueue<>((r1, r2) -> Long.compare(r1.finishTime, r2.finishTime));
		Arrays.sort(meetings, (m1, m2) -> Integer.compare(m1[0], m2[0]));
		final int[] mCnt = new int[n];
		for (int[] m : meetings) {
			while (!occupied.isEmpty() && occupied.peek().finishTime <= m[0])
				free.add(occupied.remove());

			if (free.isEmpty()) {
				final long t = occupied.peek().finishTime;
				while (!occupied.isEmpty() && occupied.peek().finishTime == t)
					free.add(occupied.remove());
			}
			final Room room = free.remove();
			mCnt[room.number] = mCnt[room.number] + 1;
			room.finishTime = Math.max(room.finishTime, m[0]) + m[1] - m[0];
			occupied.add(room);
		}

		int k = 0;
		for (int j = 1; j < n; j++)
			if (mCnt[j] > mCnt[k])
				k = j;

		return k;
	}

	static class Room {
		final int number;
		long finishTime;

		Room(int id, int finishTime) {
			this.number = id;
			this.finishTime = finishTime;
		}
	}
}
