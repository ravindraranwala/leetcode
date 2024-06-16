package com.coding.challenge.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

class IPO {
	IPO() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] profits1 = { 1, 2, 3 };
		final int[] capital1 = { 0, 1, 1 };
		assert findMaximizedCapital(2, 0, profits1, capital1) == 4;

		final int[] profits2 = { 1, 2, 3 };
		final int[] capital2 = { 0, 1, 2 };
		assert findMaximizedCapital(3, 0, profits2, capital2) == 6;
	}

	static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
		final int n = profits.length;
		final Project[] projects = new Project[n];
		for (int i = 0; i < n; i++)
			projects[i] = new Project(capital[i], profits[i]);

		Arrays.sort(projects, (a, b) -> Integer.compare(a.capital, b.capital));
		final PriorityQueue<Integer> h = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
		int cap = w;
		for (int i = 1, j = 0; i <= k; i++) {
			while (j < n && projects[j].capital <= cap) {
				h.add(projects[j].profit);
				j = j + 1;
			}
			if (h.isEmpty())
				return cap;
			cap = cap + h.remove();
		}
		return cap;
	}

	static class Project {
		private final int capital;
		private final int profit;

		public Project(int capital, int profit) {
			this.capital = capital;
			this.profit = profit;
		}
	}
}
