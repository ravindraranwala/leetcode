package com.coding.challenge.hash.table;

import java.util.Arrays;

class FindThePrefixCommonArrayOfTwoArrays {
	FindThePrefixCommonArrayOfTwoArrays() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 1, 3, 2, 4 };
		final int[] arr2 = { 3, 1, 2, 4 };
		final int[] ans1 = { 0, 2, 3, 4 };
		assert Arrays.equals(ans1, findThePrefixCommonArray(arr1, arr2));

		final int[] arr3 = { 2, 3, 1 };
		final int[] arr4 = { 3, 1, 2 };
		final int[] ans2 = { 0, 1, 3 };
		assert Arrays.equals(ans2, findThePrefixCommonArray(arr3, arr4));
	}

	static int[] findThePrefixCommonArray(int[] A, int[] B) {
		final int n = A.length;
		final boolean[] f1 = new boolean[n + 1];
		final boolean[] f2 = new boolean[n + 1];
		final int[] ans = new int[n];
		int c = 0;

		for (int i = 0; i < n; i++) {
			if (A[i] == B[i])
				c = c + 1;
			else {
				if (f2[A[i]])
					c = c + 1;
				if (f1[B[i]])
					c = c + 1;
			}
			ans[i] = c;
			f1[A[i]] = true;
			f2[B[i]] = true;
		}
		return ans;
	}
}
