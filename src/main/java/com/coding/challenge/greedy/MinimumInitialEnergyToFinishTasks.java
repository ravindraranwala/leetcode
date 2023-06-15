package com.coding.challenge.greedy;

import java.util.Arrays;

class MinimumInitialEnergyToFinishTasks {
	MinimumInitialEnergyToFinishTasks() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] tasksOne = { { 1, 2 }, { 2, 4 }, { 4, 8 } };
		assert minimumEffort(tasksOne) == 8;

		final int[][] tasksTwo = { { 1, 3 }, { 2, 4 }, { 10, 11 }, { 10, 12 }, { 8, 9 } };
		assert minimumEffort(tasksTwo) == 32;

		final int[][] tasksThree = { { 1, 7 }, { 2, 8 }, { 3, 9 }, { 4, 10 }, { 5, 11 }, { 6, 12 } };
		assert minimumEffort(tasksThree) == 27;
	}

	static int minimumEffort(int[][] tasks) {
		final int n = tasks.length;
		Arrays.sort(tasks, (a, b) -> Integer.compare(a[1] - a[0], b[1] - b[0]));
		int e = 0;
		for (int i = n - 1, r = 0; i >= 0; i--) {
			if (tasks[i][1] > r) {
				e = e + tasks[i][1] - r;
				r = 0;
			} else
				r = r - tasks[i][1];
			r = r + tasks[i][1] - tasks[i][0];
		}
		return e;
	}
}
