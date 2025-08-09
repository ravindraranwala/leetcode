package com.coding.challenge.sliding.window;

import java.util.HashMap;
import java.util.Map;

class FruitIntoBaskets {
	FruitIntoBaskets() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] fruitsOne = { 1, 2, 1 };
		assert totalFruit(fruitsOne) == 3;

		final int[] fruitsTwo = { 0, 1, 2, 2 };
		assert totalFruit(fruitsTwo) == 3;

		final int[] fruitsThree = { 1, 2, 3, 2, 2 };
		assert totalFruit(fruitsThree) == 4;
	}

	static int totalFruit(int[] fruits) {
		final int n = fruits.length;
		int maxLen = 0;
		final Map<Integer, Integer> f = new HashMap<>();
		for (int i = 0, j = 0; j < n; j++) {
			f.merge(fruits[j], 1, Integer::sum);
			while (f.size() == 3) {
				f.put(fruits[i], f.get(fruits[i]) - 1);
				if (f.get(fruits[i]) == 0)
					f.remove(fruits[i]);
				i = i + 1;
			}
			maxLen = Math.max(maxLen, j - i + 1);
		}
		return maxLen;
	}
}
