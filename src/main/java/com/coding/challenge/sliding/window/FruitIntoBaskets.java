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
		final Map<Integer, Integer> t = new HashMap<>();
		int l = 0;
		for (int i = 0, j = 0; j < n; j++) {
			t.merge(fruits[j], 1, Integer::sum);
			while (t.size() > 2) {
				t.put(fruits[i], t.get(fruits[i]) - 1);
				if (t.get(fruits[i]) == 0)
					t.remove(fruits[i]);
				i = i + 1;
			}
			l = Math.max(l, j - i + 1);
		}
		return l;
	}
}
