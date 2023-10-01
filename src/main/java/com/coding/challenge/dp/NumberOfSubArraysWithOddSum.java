package com.coding.challenge.dp;

class NumberOfSubArraysWithOddSum {
	NumberOfSubArraysWithOddSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arrOne = { 1, 3, 5 };
		assert numOfSubarrays(arrOne) == 4;

		final int[] arrTwo = { 2, 4, 6 };
		assert numOfSubarrays(arrTwo) == 0;

		final int[] arrThree = { 1, 2, 3, 4, 5, 6, 7 };
		assert numOfSubarrays(arrThree) == 16;
	}

	static int numOfSubarrays(int[] arr) {
		final int n = arr.length;
		int c = 0;
		for (int i = 0, odd = 0, even = 0; i < n; i++) {
			if (arr[i] % 2 == 0)
				even = even + 1;
			else {
				final int tmp = odd;
				odd = even + 1;
				even = tmp;
			}
			c = (c + odd) % 1000000007;
		}
		return c;
	}
}
