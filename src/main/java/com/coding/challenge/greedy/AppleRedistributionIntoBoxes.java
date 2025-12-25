package com.coding.challenge.greedy;

import java.util.Arrays;

class AppleRedistributionIntoBoxes {
	AppleRedistributionIntoBoxes() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] apple1 = { 1, 3, 2 };
		final int[] capacity1 = { 4, 3, 1, 5, 2 };
		assert minimumBoxes(apple1, capacity1) == 2;

		final int[] apple2 = { 5, 5, 5 };
		final int[] capacity2 = { 2, 4, 2, 7 };
		assert minimumBoxes(apple2, capacity2) == 4;
	}

	static int minimumBoxes(int[] apple, int[] capacity) {
		int s = 0;
		for (int a : apple)
			s = s + a;

		Arrays.sort(capacity);
		final int m = capacity.length;
		int c = 0;
		int i = m - 1;
		while (c < s) {
			c = c + capacity[i];
			i = i - 1;
		}

		return m - 1 - i;
	}
}
