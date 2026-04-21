package com.coding.challenge.greedy;

class TwoFurthestHousesWithDifferentColors {
	TwoFurthestHousesWithDifferentColors() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] colors1 = { 1, 1, 1, 6, 1, 1, 1 };
		assert maxDistance(colors1) == 3;

		final int[] colors2 = { 1, 8, 3, 8, 3 };
		assert maxDistance(colors2) == 4;

		final int[] colors3 = { 0, 1 };
		assert maxDistance(colors3) == 1;
	}

	static int maxDistance(int[] colors) {
		final int n = colors.length;
		int l1 = 0;
		int i = n - 1;
		while (i >= 0 && colors[i] == colors[0])
			i = i - 1;

		l1 = i;

		int l2 = 0;
		int j = 0;
		while (j < n && colors[j] == colors[n - 1])
			j = j + 1;

		l2 = n - j - 1;

		return Math.max(l1, l2);
	}
}
