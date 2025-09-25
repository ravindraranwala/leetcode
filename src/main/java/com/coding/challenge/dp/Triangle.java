package com.coding.challenge.dp;

import java.util.Arrays;
import java.util.List;

class Triangle {
	Triangle() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final List<List<Integer>> triangle1 = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4),
				Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3));
		assert minimumTotal(triangle1) == 11;

		final List<List<Integer>> triangle2 = Arrays.asList(Arrays.asList(-10));
		assert minimumTotal(triangle2) == -10;
	}

	static int minimumTotal(List<List<Integer>> triangle) {
		final int l = triangle.size();
		int[] prev = { triangle.get(0).get(0) };
		for (int i = 1; i < l; i++) {
			final int[] curr = new int[i + 1];
			curr[0] = Integer.MAX_VALUE;

			for (int k = 0; k < i; k++) {
				curr[k] = Math.min(curr[k], prev[k] + triangle.get(i).get(k));
				curr[k + 1] = prev[k] + triangle.get(i).get(k + 1);
			}
			prev = curr;
		}
		int minPathSum = Integer.MAX_VALUE;
		for (int j = 0; j < l; j++)
			minPathSum = Math.min(minPathSum, prev[j]);

		return minPathSum;
	}
}
