package com.coding.challenge.greedy;

import java.util.Arrays;

class TheNumberOfWeakCharactersInTheGame {
	TheNumberOfWeakCharactersInTheGame() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] propsOne = { { 5, 5 }, { 6, 3 }, { 3, 6 } };
		assert numberOfWeakCharacters(propsOne) == 0;

		final int[][] propsTwo = { { 2, 2 }, { 3, 3 } };
		assert numberOfWeakCharacters(propsTwo) == 1;

		final int[][] propsThree = { { 1, 5 }, { 10, 4 }, { 4, 3 } };
		assert numberOfWeakCharacters(propsThree) == 1;
	}

	static int numberOfWeakCharacters(int[][] properties) {
		final int n = properties.length;
		Arrays.sort(properties, (a, b) -> Integer.compare(a[0], b[0]));
		int c = 0;
		// Two pointer solution.
		for (int i = n - 1, j = n - 1, d = 0; i >= 0; i--) {
			while (properties[i][0] < properties[j][0]) {
				d = Math.max(d, properties[j][1]);
				j = j - 1;
			}
			if (properties[i][1] < d)
				c = c + 1;
		}
		return c;
	}
}
