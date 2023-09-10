package com.coding.challenge.dp;

class PartitionArrayForMaximumSum {
	PartitionArrayForMaximumSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arrOne = { 1, 15, 7, 9, 2, 5, 10 };
		assert maxSumAfterPartitioning(arrOne, 3) == 84;

		final int[] arrTwo = { 1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3 };
		assert maxSumAfterPartitioning(arrTwo, 4) == 83;

		final int[] arrThree = { 1 };
		assert maxSumAfterPartitioning(arrThree, 1) == 1;
	}

	static int maxSumAfterPartitioning(int[] arr, int k) {
		final int n = arr.length;
		final int[] s = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			final int l = Math.max(i - k, 0);
			for (int j = i, windowMax = 0; j > l; j--) {
				windowMax = Math.max(windowMax, arr[j - 1]);
				s[i] = Math.max(s[i], s[j - 1] + windowMax * (i - j + 1));
			}
		}
		return s[n];
	}
}
