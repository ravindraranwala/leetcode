package com.coding.challenge.greedy;

import java.util.Arrays;

class MostProfitAssigningWork {
	MostProfitAssigningWork() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] difficultyOne = { 2, 4, 6, 8, 10 };
		final int[] profitOne = { 10, 20, 30, 40, 50 };
		final int[] workerOne = { 4, 5, 6, 7 };
		assert maxProfitAssignment(difficultyOne, profitOne, workerOne) == 100;

		final int[] difficultyTwo = { 85, 47, 57 };
		final int[] profitTwo = { 24, 66, 99 };
		final int[] workerTwo = { 40, 25, 25 };
		assert maxProfitAssignment(difficultyTwo, profitTwo, workerTwo) == 0;

		final int[] difficultyThree = { 13, 37, 58 };
		final int[] profitThree = { 4, 90, 96 };
		final int[] workerThree = { 34, 73, 45 };
		assert maxProfitAssignment(difficultyThree, profitThree, workerThree) == 190;
	}

	static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
		final int n = difficulty.length;
		final int[][] jobs = new int[n][2];
		for (int i = 0; i < n; i++)
			jobs[i] = new int[] { difficulty[i], profit[i] };

		Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
		Arrays.sort(worker);
		int p = 0;
		for (int i = 0, j = 0, maxProfit = 0, m = worker.length; i < m; i++) {
			while (j < n && jobs[j][0] <= worker[i]) {
				maxProfit = Math.max(maxProfit, jobs[j][1]);
				j = j + 1;
			}
			p = p + maxProfit;
		}
		return p;
	}
}
