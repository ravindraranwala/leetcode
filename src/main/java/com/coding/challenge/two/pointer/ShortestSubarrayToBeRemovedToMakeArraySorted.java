package com.coding.challenge.two.pointer;

class ShortestSubarrayToBeRemovedToMakeArraySorted {
	ShortestSubarrayToBeRemovedToMakeArraySorted() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] a1 = { 1, 2, 3, 10, 4, 2, 3, 5 };
		assert findLengthOfShortestSubarray(a1) == 3;

		final int[] a2 = { 5, 4, 3, 2, 1 };
		assert findLengthOfShortestSubarray(a2) == 4;

		final int[] a3 = { 1, 2, 3 };
		assert findLengthOfShortestSubarray(a3) == 0;
	}

	static int findLengthOfShortestSubarray(int[] arr) {
		final int n = arr.length;
		int j = n - 2;
		while (j >= 0 && arr[j] <= arr[j + 1])
			j = j - 1;

		j = j + 1;
		int l = j;
		if (l == 0)
			return l;

		// two-pointer technique.
		int i = 0;
		for (int prev = arr[0]; i < n && arr[i] >= prev; i++) {
			while (j < n && arr[j] < arr[i])
				j = j + 1;
			l = Math.min(l, j - i - 1);
			prev = arr[i];
		}
		return l;
	}
}
