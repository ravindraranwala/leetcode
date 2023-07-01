package com.coding.challenge.dp;

import java.util.Arrays;
import java.util.List;

class TriangleMinPathSum {
	TriangleMinPathSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		List<List<Integer>> triangleOne = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7),
				Arrays.asList(4, 1, 8, 3));
		assert minimumTotal(triangleOne) == 11;

		List<List<Integer>> triangleTwo = Arrays.asList(Arrays.asList(-10));
		assert minimumTotal(triangleTwo) == -10;
	}

	static int minimumTotal(List<List<Integer>> triangle) {
		final int n = triangle.size();
		final int[][] t = new int[2][n];
		for (int j = 0; j < n; j++) {
			t[0][j] = Integer.MAX_VALUE;
			t[1][j] = Integer.MAX_VALUE;
		}

		t[0][0] = triangle.get(0).get(0);
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j <= i; j++) {
				t[(i + 1) % 2][j] = Math.min(t[(i + 1) % 2][j], t[i % 2][j] + triangle.get(i + 1).get(j));
				t[(i + 1) % 2][j + 1] = Math.min(t[(i + 1) % 2][j + 1], t[i % 2][j] + triangle.get(i + 1).get(j + 1));
				t[i % 2][j] = Integer.MAX_VALUE;
			}
		}

		int s = t[(n - 1) % 2][0];
		for (int j = 1; j < n; j++)
			s = Math.min(s, t[(n - 1) % 2][j]);
		return s;
	}
}
