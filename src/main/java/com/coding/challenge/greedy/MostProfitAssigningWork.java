package com.coding.challenge.greedy;

import java.util.Arrays;

class MostProfitAssigningWork {
	MostProfitAssigningWork() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] difficulty1 = { 2, 4, 6, 8, 10 };
		final int[] profit1 = { 10, 20, 30, 40, 50 };
		final int[] worker1 = { 4, 5, 6, 7 };
		assert maxProfitAssignment(difficulty1, profit1, worker1) == 100;

		final int[] difficulty2 = { 85, 47, 57 };
		final int[] profit2 = { 24, 66, 99 };
		final int[] worker2 = { 40, 25, 25 };
		assert maxProfitAssignment(difficulty2, profit2, worker2) == 0;
	}

	static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
		final int m = worker.length;
		final int n = difficulty.length;
		final Job[] jobs = new Job[n];
		for (int i = 0; i < n; i++)
			jobs[i] = new Job(difficulty[i], profit[i]);

		Arrays.sort(jobs, (a, b) -> Integer.compare(a.d, b.d));

		Arrays.sort(worker);
		int p = 0;
		for (int i = 0, j = 0, maxProfit = 0; i < m; i++) {
			while (j < n && jobs[j].d <= worker[i]) {
				maxProfit = Math.max(maxProfit, jobs[j].p);
				j = j + 1;
			}

			p = p + maxProfit;
		}
		return p;
	}

	private static class Job {
		private final int d;
		private final int p;

		Job(int d, int p) {
			this.d = d;
			this.p = p;
		}
	}
}
