package com.coding.challenge.hash.table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class FindTheNumberOfDistinctColorsAmongTheBalls {
	FindTheNumberOfDistinctColorsAmongTheBalls() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] queries1 = { { 1, 4 }, { 2, 5 }, { 1, 3 }, { 3, 4 } };
		final int[] a1 = { 1, 2, 2, 3 };
		assert Arrays.equals(a1, queryResults(4, queries1));

		final int[][] queries2 = { { 0, 1 }, { 1, 2 }, { 2, 2 }, { 3, 4 }, { 4, 5 } };
		final int[] a2 = { 1, 2, 2, 3, 4 };
		assert Arrays.equals(a2, queryResults(4, queries2));
	}

	static int[] queryResults(int limit, int[][] queries) {
		final int n = queries.length;
		final int[] a = new int[n];
		final Map<Integer, Integer> ballColor = new HashMap<>();
		final Map<Integer, Integer> colorFreq = new HashMap<>();

		for (int i = 0; i < n; i++) {
			final int[] q = queries[i];
			if (ballColor.containsKey(q[0])) {
				final int currColor = ballColor.get(q[0]);
				if (colorFreq.get(currColor) == 1)
					colorFreq.remove(currColor);
				else
					colorFreq.put(currColor, colorFreq.get(currColor) - 1);
			}
			colorFreq.merge(q[1], 1, Integer::sum);
			ballColor.put(q[0], q[1]);
			a[i] = colorFreq.size();
		}
		return a;
	}
}
