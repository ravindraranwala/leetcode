package com.coding.challenge.greedy;

import java.util.HashSet;
import java.util.Set;

class MaximumNumberOfIntegersToChooseFromRange_I {
	MaximumNumberOfIntegersToChooseFromRange_I() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] banned1 = { 1, 6, 5 };
		assert maxCount(banned1, 5, 6) == 2;

		final int[] banned2 = { 1, 2, 3, 4, 5, 6, 7 };
		assert maxCount(banned2, 8, 1) == 0;

		final int[] banned3 = { 11 };
		assert maxCount(banned3, 7, 50) == 7;
	}

	static int maxCount(int[] banned, int n, int maxSum) {
		final Set<Integer> s = new HashSet<>();
		for (int b : banned)
			s.add(b);

		int c = 0;
		for (int i = 1, sum = 0; i <= n && sum + i <= maxSum; i++) {
			if (!s.contains(i)) {
				sum = sum + i;
				c = c + 1;
			}
		}
		return c;
	}
}
