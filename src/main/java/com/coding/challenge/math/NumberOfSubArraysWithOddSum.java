package com.coding.challenge.math;

class NumberOfSubArraysWithOddSum {
	private static final int MOD = 1000000007;

	NumberOfSubArraysWithOddSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 1, 3, 5 };
		assert numOfSubarrays(arr1) == 4;

		final int[] arr2 = { 2, 4, 6 };
		assert numOfSubarrays(arr2) == 0;

		final int[] arr3 = { 1, 2, 3, 4, 5, 6, 7 };
		assert numOfSubarrays(arr3) == 16;
	}

	static int numOfSubarrays(int[] arr) {
		final int n = arr.length;
		int oddCnt = 0;
		for (int i = 0, prevOddCnt = 0; i < n; i++) {
			if (arr[i] % 2 == 1) {
				prevOddCnt = i - prevOddCnt + 1;
			}
			oddCnt = (oddCnt + prevOddCnt) % MOD;
		}
		return oddCnt;
	}
}
