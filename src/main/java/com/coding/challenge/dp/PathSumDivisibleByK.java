package com.coding.challenge.dp;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class PathSumDivisibleByK {
	private static final int MOD = 1000000007;

	PathSumDivisibleByK() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 5, 2, 4 }, { 3, 0, 5 }, { 0, 7, 2 } };
		assert 2 == numberOfPaths(gridOne, 3);

		final int[][] gridTwo = { { 0, 0 } };
		assert 1 == numberOfPaths(gridTwo, 5);

		final int[][] gridThree = { { 7, 3, 4, 9 }, { 2, 3, 6, 2 }, { 2, 3, 7, 0 } };
		assert 10 == numberOfPaths(gridThree, 1);
	}

	static int numberOfPaths(int[][] grid, int k) {
		final int m = grid.length;
		final int n = grid[0].length;
		final Map<Integer, Integer>[][] p = new Map[m][n];
		// base case of the recurrence
		p[m - 1][n - 1] = Collections.singletonMap(grid[m - 1][n - 1] % k, 1);
		for (int i = m - 2; i >= 0; i--) {
			final Entry<Integer, Integer> e = p[i + 1][n - 1].entrySet().iterator().next();
			p[i][n - 1] = Collections.singletonMap((e.getKey() + grid[i][n - 1]) % k, e.getValue());

		}

		for (int j = n - 2; j >= 0; j--) {
			final Entry<Integer, Integer> e = p[m - 1][j + 1].entrySet().iterator().next();
			p[m - 1][j] = Collections.singletonMap((e.getKey() + grid[m - 1][j]) % k, e.getValue());
		}

		// recursive step.
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				p[i][j] = new HashMap<>();
				for (Entry<Integer, Integer> e : p[i][j + 1].entrySet())
					p[i][j].merge((e.getKey() + grid[i][j]) % k, e.getValue(), (a, b) -> (a + b) % MOD);

				for (Entry<Integer, Integer> e : p[i + 1][j].entrySet())
					p[i][j].merge((e.getKey() + grid[i][j]) % k, e.getValue(), (a, b) -> (a + b) % MOD);
			}
		}
		return p[0][0].getOrDefault(0, 0);
	}
}
