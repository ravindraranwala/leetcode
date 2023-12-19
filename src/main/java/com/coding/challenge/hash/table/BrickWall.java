package com.coding.challenge.hash.table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BrickWall {
	BrickWall() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final List<List<Integer>> wall1 = Arrays.asList(Arrays.asList(1, 2, 2, 1), Arrays.asList(3, 1, 2),
				Arrays.asList(1, 3, 2), Arrays.asList(2, 4), Arrays.asList(3, 1, 2), Arrays.asList(1, 3, 1, 1));
		assert leastBricks(wall1) == 2;

		final List<List<Integer>> wall2 = Arrays.asList(Arrays.asList(1), Arrays.asList(1), Arrays.asList(1));
		assert leastBricks(wall2) == 3;
	}

	static int leastBricks(List<List<Integer>> wall) {
		int width = 0;
		for (int w : wall.get(0))
			width = width + w;
		int maxBoarders = 0;
		final Map<Integer, Integer> t = new HashMap<>();
		for (List<Integer> row : wall) {
			int c = 0;
			for (int w : row) {
				c = c + w;
				final int b = t.merge(c, 1, Integer::sum);
				if (c != width)
					maxBoarders = Math.max(maxBoarders, b);
			}
		}

		return wall.size() - maxBoarders;
	}
}
