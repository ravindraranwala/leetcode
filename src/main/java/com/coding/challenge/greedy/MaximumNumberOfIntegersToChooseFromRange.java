package com.coding.challenge.greedy;

import java.util.HashSet;
import java.util.Set;

class MaximumNumberOfIntegersToChooseFromRange {
	MaximumNumberOfIntegersToChooseFromRange() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] b1 = { 1, 6, 5 };
		assert maxCount(b1, 5, 6) == 2;

		final int[] b2 = { 1, 2, 3, 4, 5, 6, 7 };
		assert maxCount(b2, 8, 1) == 0;

		final int[] b3 = { 11 };
		assert maxCount(b3, 7, 50) == 7;
	}

	static int maxCount(int[] banned, int n, int maxSum) {
		final Set<Integer> s = new HashSet<>();
		for (int v : banned)
			s.add(v);

		int c = 0;
		for (int i = 1, sum = 0; i <= n; i++) {
			if (!s.contains(i)) {
				sum = sum + i;
				if (sum <= maxSum)
					c = c + 1;
			}

		}
		return c;
	}
}
