package com.coding.challenge.greedy;

import java.util.Arrays;

class MaximizeHappinessOfSelectedChildren {
	MaximizeHappinessOfSelectedChildren() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] happiness1 = { 1, 2, 3 };
		assert maximumHappinessSum(happiness1, 2) == 4;

		final int[] happiness2 = { 1, 1, 1, 1 };
		assert maximumHappinessSum(happiness2, 2) == 1;

		final int[] happiness3 = { 2, 3, 4, 5 };
		assert maximumHappinessSum(happiness3, 1) == 5;
	}

	static long maximumHappinessSum(int[] happiness, int k) {
		final int n = happiness.length;
		Arrays.sort(happiness);
		long h = 0;
		for (int i = 0; i < k; i++)
			h = h + Math.max(happiness[n - i - 1] - i, 0);

		return h;
	}
}
