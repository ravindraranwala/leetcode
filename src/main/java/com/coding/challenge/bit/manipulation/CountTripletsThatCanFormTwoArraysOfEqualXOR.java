package com.coding.challenge.bit.manipulation;

class CountTripletsThatCanFormTwoArraysOfEqualXOR {
	CountTripletsThatCanFormTwoArraysOfEqualXOR() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 2, 3, 1, 6, 7 };
		assert countTriplets(arr1) == 4;

		final int[] arr2 = { 1, 1, 1, 1, 1 };
		assert countTriplets(arr2) == 10;

		final int[] arr3 = { 10 };
		assert countTriplets(arr3) == 0;
	}

	static int countTriplets(int[] arr) {
		final int n = arr.length;
		int c = 0;
		for (int i = 0; i < n; i++) {
			int xorVal = 0;
			for (int j = i; j < n; j++) {
				xorVal = xorVal ^ arr[j];
				if (xorVal == 0)
					c = c + j - i;
			}
		}
		return c;
	}
}
