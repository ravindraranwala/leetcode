package com.coding.challenge.dp;

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
		final int ans1 = Math.min(rotationsForEqualValue(tops, bottoms, tops[0], tops),
				rotationsForEqualValue(tops, bottoms, bottoms[0], tops));
		if (ans1 == Integer.MAX_VALUE)
			return -1;
		final int ans2 = Math.min(rotationsForEqualValue(tops, bottoms, tops[0], bottoms),
				rotationsForEqualValue(tops, bottoms, bottoms[0], bottoms));
		return Math.min(ans1, ans2);
	}

	private static int rotationsForEqualValue(int[] tops, int[] bottoms, int val, int[] a) {
		final int n = tops.length;
		int r = 0;
		for (int i = 0; i < n; i++) {
			if (tops[i] != val && bottoms[i] != val)
				return Integer.MAX_VALUE;
			if (a[i] != val)
				r = r + 1;
		}
		return r;
	}
}
