package com.coding.challenge.dp;

class LongestMountainInArray {
	LongestMountainInArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arrOne = { 2, 1, 4, 7, 3, 2, 5 };
		assert longestMountain(arrOne) == 5;

		final int[] arrTwo = { 2, 2, 2 };
		assert longestMountain(arrTwo) == 0;

		final int[] arrThree = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		assert longestMountain(arrThree) == 0;
	}

	static int longestMountain(int[] arr) {
		final int n = arr.length;
		final int[] left = new int[n];

		// left side
		for (int i = 1; i < n; i++) {
			if (arr[i] > arr[i - 1])
				left[i] = left[i - 1] + 1;
			else
				left[i] = 0;
		}

		// right side.
		int l = 0;
		for (int i = n - 2, right = 0; i >= 0; i--) {
			if (arr[i] > arr[i + 1]) {
				right = right + 1;
				// finding the mountain length.
				if (left[i] > 0)
					l = Math.max(l, left[i] + right + 1);
			} else
				right = 0;
		}

		return l;
	}
}
