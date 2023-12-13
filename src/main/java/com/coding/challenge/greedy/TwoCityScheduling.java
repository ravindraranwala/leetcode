package com.coding.challenge.greedy;

import java.util.Arrays;

class TwoCityScheduling {
	TwoCityScheduling() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] costsOne = { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };
		assert twoCitySchedCost(costsOne) == 110;

		final int[][] costsTwo = { { 259, 770 }, { 448, 54 }, { 926, 667 }, { 184, 139 }, { 840, 118 }, { 577, 469 } };
		assert twoCitySchedCost(costsTwo) == 1859;

		final int[][] costsThree = { { 515, 563 }, { 451, 713 }, { 537, 709 }, { 343, 819 }, { 855, 779 }, { 457, 60 },
				{ 650, 359 }, { 631, 42 } };
		assert twoCitySchedCost(costsThree) == 3086;
	}

	static int twoCitySchedCost(int[][] costs) {
		int s1 = 0;
		int s2 = 0;
		int minCost = 0;
		for (int[] cost : costs) {
			if (cost[0] <= cost[1]) {
				s1 = s1 + 1;
				minCost = minCost + cost[0];
			} else {
				s2 = s2 + 1;
				minCost = minCost + cost[1];
			}
		}
		Arrays.sort(costs, (a, b) -> Integer.compare(Math.abs(a[0] - a[1]), Math.abs(b[0] - b[1])));
		final int m = Math.abs(s1 - s2) / 2;
		int movingCost = 0;
		for (int i = 0, k = 0; k < m; i++) {
			if (s1 >= s2 && costs[i][0] <= costs[i][1]) {
				movingCost = movingCost + costs[i][1] - costs[i][0];
				k = k + 1;
			} else if (s2 > s1 && costs[i][1] < costs[i][0]) {
				movingCost = movingCost + costs[i][0] - costs[i][1];
				k = k + 1;
			}
		}
		return minCost + movingCost;
	}
}
