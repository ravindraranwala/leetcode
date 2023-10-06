package com.coding.challenge.two.pointer;

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

		final int[] arrFour = { 0, 2, 0, 2, 1, 2, 3, 4, 4, 1 };
		assert longestMountain(arrFour) == 3;

		final int[] arrFive = { 3, 3, 2, 2, 1, 1, 0, 0, 0, 1, 3, 3, 3, 3, 0, 0, 2, 0, 3, 2, 2, 0, 0, 3, 2, 0, 1, 0, 3,
				1, 1, 1, 0, 1, 0, 3, 1, 3, 2, 2, 3, 2, 1, 1, 1, 3, 3, 0, 2, 2, 0, 3, 0, 3, 3, 1, 1, 2, 0, 0, 1, 3, 0, 1,
				3, 0, 0, 1, 2, 0, 0, 0, 0, 0, 2, 0, 1, 3, 0, 1, 3, 3, 3, 1, 0, 3, 3, 1, 0, 1, 0, 2, 3, 1, 1, 2, 3, 1, 2,
				3 };
		assert longestMountain(arrFive) == 4;
	}

	static int longestMountain(int[] arr) {
		final int n = arr.length;
		int l = 0;

		int i = 0;
		while (i < n - 1) {
			while (i < n - 1 && arr[i + 1] == arr[i])
				i = i + 1;
			int j = i;
			
			while (j < n - 1 && arr[j + 1] > arr[j])
				j = j + 1;

			int k = j;
			while (k < n - 1 && arr[k + 1] < arr[k])
				k = k + 1;

			if (j > i && k > j)
				l = Math.max(l, k - i + 1);
			i = k;
		}
		return l;
	}
}
