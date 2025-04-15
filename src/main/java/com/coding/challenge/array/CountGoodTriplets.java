package com.coding.challenge.array;

class CountGoodTriplets {
	CountGoodTriplets() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 3, 0, 1, 1, 9, 7 };
		assert countGoodTriplets(arr1, 7, 2, 3) == 4;

		final int[] arr2 = { 1, 1, 2, 2, 3 };
		assert countGoodTriplets(arr2, 0, 0, 1) == 0;
	}

	static int countGoodTriplets(int[] arr, int a, int b, int c) {
		final int n = arr.length;
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (Math.abs(arr[i] - arr[j]) <= a) {
					for (int k = j + 1; k < n; k++)
						if (Math.abs(arr[k] - arr[j]) <= b && Math.abs(arr[k] - arr[i]) <= c)
							cnt = cnt + 1;
				}
			}
		}
		return cnt;
	}
}
