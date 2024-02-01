package com.coding.challenge.greedy;

import java.util.PriorityQueue;

class TaskScheduler {
	private static final char FIRST_LETTER = 'A';

	TaskScheduler() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final char[] tasks1 = { 'A', 'A', 'A', 'B', 'B', 'B' };
		assert leastInterval(tasks1, 2) == 8;

		assert leastInterval(tasks1, 0) == 6;

		final char[] tasks2 = { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		assert leastInterval(tasks2, 2) == 16;

		final char[] tasks3 = { 'A', 'B' };
		assert leastInterval(tasks3, 5) == 2;
	}

	static int leastInterval(char[] tasks, int n) {
		final int[] f = new int[26];
		for (char ch : tasks)
			f[ch - FIRST_LETTER] = f[ch - FIRST_LETTER] + 1;

		final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i, j) -> Integer.compare(f[j], f[i]));
		for (int i = 0; i < 26; i++)
			if (f[i] > 0)
				maxHeap.add(i);

		int time = 0;
		while (!maxHeap.isEmpty()) {
			int coolDown = n + 1;
			final boolean[] consumed = new boolean[26];
			while (!maxHeap.isEmpty() && coolDown > 0) {
				final int i = maxHeap.remove();
				consumed[i] = true;
				f[i] = f[i] - 1;
				coolDown = coolDown - 1;
				time = time + 1;
			}
			// insert back to the heap with updated frequency values.
			for (int i = 0; i < 26; i++)
				if (consumed[i] && f[i] > 0)
					maxHeap.add(i);

			if (!maxHeap.isEmpty())
				time = time + coolDown;
		}
		return time;
	}
}
