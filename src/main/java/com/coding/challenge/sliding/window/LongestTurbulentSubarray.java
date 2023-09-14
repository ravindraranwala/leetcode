package com.coding.challenge.sliding.window;

class LongestTurbulentSubarray {
	LongestTurbulentSubarray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arrOne = { 9, 4, 2, 10, 7, 8, 8, 1, 9 };
		assert maxTurbulenceSize(arrOne) == 5;

		final int[] arrTwo = { 4, 8, 12, 16 };
		assert maxTurbulenceSize(arrTwo) == 2;

		final int[] arrThree = { 100 };
		assert maxTurbulenceSize(arrThree) == 1;

		final int[] arrFour = { 0, 8, 45, 88, 48, 68, 28, 55, 17, 24 };
		assert maxTurbulenceSize(arrFour) == 8;
	}

	static int maxTurbulenceSize(int[] arr) {
		final int n = arr.length;
		int l = 1;
		for (int i = 0, j = 1, prevCmp = 0; j < n; j++) {
			final int currCmp = Integer.compare(arr[j - 1], arr[j]);
			if (arr[j] == arr[j - 1])
				i = j;
			else if (currCmp == prevCmp)
				i = j - 1;
			else
				l = Math.max(l, j - i + 1);

			prevCmp = currCmp;
		}
		return l;
	}
}
