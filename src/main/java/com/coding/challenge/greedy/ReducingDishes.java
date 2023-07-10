package com.coding.challenge.greedy;

import java.util.Arrays;

class ReducingDishes {
	ReducingDishes() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] satisfactionOne = { -1, -8, 0, 5, -9 };
		assert maxSatisfaction(satisfactionOne) == 14;

		final int[] satisfactionTwo = { 4, 3, 2 };
		assert maxSatisfaction(satisfactionTwo) == 20;

		final int[] satisfactionThree = { -1, -4, -5 };
		assert maxSatisfaction(satisfactionThree) == 0;
	}

	static int maxSatisfaction(int[] satisfaction) {
		final int n = satisfaction.length;
		Arrays.sort(satisfaction);
		int mc = 0;

		for (int i = n - 1, p = 0, c = 0; i >= 0; i--) {
			c = c + p + satisfaction[i];
			mc = Math.max(mc, c);
			p = p + satisfaction[i];
		}
		return Math.max(mc, 0);
	}
}
