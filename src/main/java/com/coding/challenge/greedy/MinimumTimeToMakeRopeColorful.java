package com.coding.challenge.greedy;

class MinimumTimeToMakeRopeColorful {
	MinimumTimeToMakeRopeColorful() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String colorsOne = "abaac";
		final int[] neededTimeOne = { 1, 2, 3, 4, 5 };
		assert minCost(colorsOne, neededTimeOne) == 3;

		final String colorsTwo = "abc";
		final int[] neededTimeTwo = { 1, 2, 3 };
		assert minCost(colorsTwo, neededTimeTwo) == 0;

		final String colorsThree = "aabaa";
		final int[] neededTimeThree = { 1, 2, 3, 4, 1 };
		assert minCost(colorsThree, neededTimeThree) == 2;
	}

	static int minCost(String colors, int[] neededTime) {
		final int n = neededTime.length;
		int t = 0;

		// loop invariant j <= i
		for (int i = 1, j = 0; i < n; i++) {
			if (colors.charAt(i) == colors.charAt(j)) {
				if (neededTime[i] > neededTime[j]) {
					t = t + neededTime[j];
					j = i;
				} else
					t = t + neededTime[i];
			} else
				j = i;
		}
		return t;
	}
}
