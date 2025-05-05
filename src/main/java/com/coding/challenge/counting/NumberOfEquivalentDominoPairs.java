package com.coding.challenge.counting;

class NumberOfEquivalentDominoPairs {
	NumberOfEquivalentDominoPairs() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] dominoes1 = { { 1, 2 }, { 2, 1 }, { 3, 4 }, { 5, 6 } };
		assert numEquivDominoPairs(dominoes1) == 1;

		final int[][] dominoes2 = { { 1, 2 }, { 1, 2 }, { 1, 1 }, { 1, 2 }, { 2, 2 } };
		assert numEquivDominoPairs(dominoes2) == 3;
	}

	static int numEquivDominoPairs(int[][] dominoes) {
		int p = 0;
		final int[][] f = new int[10][10];
		for (int[] d : dominoes) {
			if (d[0] <= d[1]) {
				p = p + f[d[0]][d[1]];
				f[d[0]][d[1]] = f[d[0]][d[1]] + 1;
			} else {
				p = p + f[d[1]][d[0]];
				f[d[1]][d[0]] = f[d[1]][d[0]] + 1;
			}
		}
		return p;
	}
}
