package com.coding.challenge.bit.manipulation;

import java.util.Arrays;

class XORQueriesOfASubarray {
	XORQueriesOfASubarray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 1, 3, 4, 8 };
		final int[][] queries1 = { { 0, 1 }, { 1, 2 }, { 0, 3 }, { 3, 3 } };
		final int[] ans1 = { 2, 7, 14, 8 };
		assert Arrays.equals(ans1, xorQueries(arr1, queries1));

		final int[] arr2 = { 4, 8, 2, 10 };
		final int[][] queries2 = { { 2, 3 }, { 1, 3 }, { 0, 0 }, { 0, 3 } };
		final int[] ans2 = { 8, 0, 4, 4 };
		assert Arrays.equals(ans2, xorQueries(arr2, queries2));
	}

	static int[] xorQueries(int[] arr, int[][] queries) {
		final int n = arr.length;
		final int[] prefixXor = new int[n];
		prefixXor[0] = arr[0];
		for (int i = 1; i < n; i++)
			prefixXor[i] = prefixXor[i - 1] ^ arr[i];

		final int m = queries.length;
		final int[] ans = new int[m];
		for (int i = 0; i < m; i++)
			/*
			 * XOR a number with itself yields 0. So, if we XOR arr[0...k] with arr[0],
			 * arr[1] ... arr[j], then that effect is negated and what we get is the XOR[j +
			 * 1 ... k].
			 */
			ans[i] = prefixXor[queries[i][1]] ^ prefixXor[queries[i][0]] ^ arr[queries[i][0]];

		return ans;
	}
}
