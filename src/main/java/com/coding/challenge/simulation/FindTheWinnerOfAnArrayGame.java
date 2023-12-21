package com.coding.challenge.simulation;

class FindTheWinnerOfAnArrayGame {
	FindTheWinnerOfAnArrayGame() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 2, 1, 3, 5, 4, 6, 7 };
		assert getWinner(arr1, 2) == 5;

		final int[] arr2 = { 3, 2, 1 };
		assert getWinner(arr2, 10) == 3;
	}

	static int getWinner(int[] arr, int k) {
		int largest = arr[0];
		int f = 0;
		final int n = arr.length;

		for (int i = 1; i < n; i++) {
			if (arr[i] < largest)
				f = f + 1;
			else {
				largest = arr[i];
				f = 1;
			}
			if (f == k)
				return largest;
		}
		return largest;
	}
}
