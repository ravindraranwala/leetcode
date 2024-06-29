package com.coding.challenge.greedy;

import java.util.Arrays;

class MaximumTotalImportanceOfRoads {
	MaximumTotalImportanceOfRoads() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] roads1 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 0, 2 }, { 1, 3 }, { 2, 4 } };
		assert maximumImportance(5, roads1) == 43;

		final int[][] roads2 = { { 0, 3 }, { 2, 4 }, { 1, 3 } };
		assert maximumImportance(5, roads2) == 20;
	}

	static long maximumImportance(int n, int[][] roads) {
		final int[] degree = new int[n];
		for (int[] road : roads) {
			degree[road[0]] = degree[road[0]] + 1;
			degree[road[1]] = degree[road[1]] + 1;
		}

		int maxDegree = 0;
		for (int d : degree)
			maxDegree = Math.max(maxDegree, d);

		final int[] c = new int[maxDegree + 1];
		for (int d : degree)
			c[d] = c[d] + 1;

		for (int i = 1; i <= maxDegree; i++)
			c[i] = c[i - 1] + c[i];

		long importance = 0;
		for (int i = 0; i < n; i++) {
			importance = importance + (long) degree[i] * c[degree[i]];
			c[degree[i]] = c[degree[i]] - 1;
		}

		return importance;
	}

	static long maximumImportanceNaive(int n, int[][] roads) {
		final int[] degree = new int[n];
		for (int[] road : roads) {
			degree[road[0]] = degree[road[0]] + 1;
			degree[road[1]] = degree[road[1]] + 1;
		}

		Arrays.sort(degree);
		long importance = 0;
		for (int i = 0; i < n; i++)
			importance = importance + (long) degree[i] * (i + 1);

		return importance;
	}
}
