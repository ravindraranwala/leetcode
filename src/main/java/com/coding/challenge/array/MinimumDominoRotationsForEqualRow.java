package com.coding.challenge.array;

class MinimumDominoRotationsForEqualRow {
	MinimumDominoRotationsForEqualRow() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] tops1 = { 2, 1, 2, 4, 2, 2 };
		final int[] bottoms1 = { 5, 2, 6, 2, 3, 2 };
		assert minDominoRotations(tops1, bottoms1) == 2;

		final int[] tops2 = { 3, 5, 1, 2, 3 };
		final int[] bottoms2 = { 3, 6, 3, 3, 4 };
		assert minDominoRotations(tops2, bottoms2) == -1;
	}

	static int minDominoRotations(int[] tops, int[] bottoms) {
		final int n = tops.length;
		final int[] topFreq = new int[7];
		final int[] bottomFreq = new int[7];
		final int[] identicalFreq = new int[7];

		for (int i = 0; i < n; i++) {
			if (tops[i] == bottoms[i])
				identicalFreq[tops[i]] = identicalFreq[tops[i]] + 1;
			else {
				topFreq[tops[i]] = topFreq[tops[i]] + 1;
				bottomFreq[bottoms[i]] = bottomFreq[bottoms[i]] + 1;
			}
		}

		if (topFreq[tops[0]] + bottomFreq[tops[0]] + identicalFreq[tops[0]] == n)
			return Math.min(topFreq[tops[0]], bottomFreq[tops[0]]);
		if (topFreq[bottoms[0]] + bottomFreq[bottoms[0]] + identicalFreq[bottoms[0]] == n)
			return Math.min(topFreq[bottoms[0]], bottomFreq[bottoms[0]]);

		return -1;
	}
}
