package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.Map;

class CountCoveredBuildings {
	CountCoveredBuildings() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] buildings1 = { { 1, 2 }, { 2, 2 }, { 3, 2 }, { 2, 1 }, { 2, 3 } };
		assert countCoveredBuildings(3, buildings1) == 1;

		final int[][] buildings2 = { { 1, 1 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };
		assert countCoveredBuildings(3, buildings2) == 0;

		final int[][] buildings3 = { { 1, 3 }, { 3, 2 }, { 3, 3 }, { 3, 5 }, { 5, 3 } };
		assert countCoveredBuildings(5, buildings3) == 1;
	}

	static int countCoveredBuildings(int n, int[][] buildings) {
		final Map<Integer, Integer> rowMinCol = new HashMap<>();
		final Map<Integer, Integer> rowMaxCol = new HashMap<>();
		final Map<Integer, Integer> colMinRow = new HashMap<>();
		final Map<Integer, Integer> colMaxRow = new HashMap<>();

		for (int[] b : buildings) {
			rowMinCol.merge(b[0], b[1], Math::min);
			rowMaxCol.merge(b[0], b[1], Math::max);
			colMinRow.merge(b[1], b[0], Math::min);
			colMaxRow.merge(b[1], b[0], Math::max);
		}

		int c = 0;
		for (int[] b : buildings)
			if (b[1] > rowMinCol.get(b[0]) && b[1] < rowMaxCol.get(b[0]) && b[0] > colMinRow.get(b[1])
					&& b[0] < colMaxRow.get(b[1]))
				c = c + 1;

		return c;
	}
}
