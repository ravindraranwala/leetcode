package com.coding.challenge.greedy;

import java.util.Arrays;

class MinimumInitialEnergyToFinishTasks {
	MinimumInitialEnergyToFinishTasks() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] tasks1 = { { 1, 2 }, { 2, 4 }, { 4, 8 } };
		assert minimumEffort(tasks1) == 8;

		final int[][] tasks2 = { { 1, 3 }, { 2, 4 }, { 10, 11 }, { 10, 12 }, { 8, 9 } };
		assert minimumEffort(tasks2) == 32;

		final int[][] tasks3 = { { 1, 7 }, { 2, 8 }, { 3, 9 }, { 4, 10 }, { 5, 11 }, { 6, 12 } };
		assert minimumEffort(tasks3) == 27;
	}

	static int minimumEffort(int[][] tasks) {
		final int n = tasks.length;
		Arrays.sort(tasks, (o1, o2) -> Integer.compare(o2[1] - o2[0], o1[1] - o1[0]));
		int effort = 0;
		for (int i = 0, rem = 0; i < n; i++) {
			if (rem < tasks[i][1]) {
				effort = effort + tasks[i][1] - rem;
				rem = tasks[i][1] - tasks[i][0];
			} else
				rem = rem - tasks[i][0];
		}
		return effort;
	}
}
