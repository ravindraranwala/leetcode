package com.coding.challenge.dp;

import java.util.HashMap;
import java.util.Map;

class FindTwoNonOverlappingSubarraysEachWithTargetSum {
	FindTwoNonOverlappingSubarraysEachWithTargetSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 3, 2, 2, 4, 3 };
		assert minSumOfLengthsSlidingWindow(arr1, 3) == 2;

		final int[] arr2 = { 7, 3, 4, 7 };
		assert minSumOfLengthsSlidingWindow(arr2, 7) == 2;

		final int[] arr3 = { 4, 3, 2, 6, 2, 3, 4 };
		assert minSumOfLengthsSlidingWindow(arr3, 6) == -1;

		final int[] arr4 = { 3, 4, 7 };
		assert minSumOfLengthsSlidingWindow(arr4, 7) == 3;
	}

	static int minSumOfLengths(int[] arr, int target) {
		final int n = arr.length;
		int minLen = n + 1;
		final int[] l = new int[n + 1];
		l[n] = n + 1;
		final Map<Integer, Integer> sumToIdx = new HashMap<>();
		// init hash table.
		sumToIdx.put(0, n);

		for (int i = n - 1, sum = 0; i >= 0; i--) {
			sum = sum + arr[i];
			l[i] = l[i + 1];
			if (sumToIdx.containsKey(sum - target)) {
				final int j = sumToIdx.get(sum - target);
				l[i] = Math.min(l[i + 1], j - i);
				minLen = Math.min(minLen, j - i + l[j]);
			}

			sumToIdx.put(sum, i);
		}
		return minLen > n ? -1 : minLen;
	}

	static int minSumOfLengthsSlidingWindow(int[] arr, int target) {
		final int n = arr.length;
		int minLen = n + 1;
		final int[] l = new int[n + 1];
		l[n] = n + 1;

		for (int i = n - 1, j = n - 1, windowSum = 0; i >= 0; i--) {
			windowSum = windowSum + arr[i];
			while (windowSum > target) {
				windowSum = windowSum - arr[j];
				j = j - 1;
			}
			l[i] = l[i + 1];
			if (windowSum == target) {
				l[i] = Math.min(l[i + 1], j - i + 1);
				minLen = Math.min(minLen, j - i + 1 + l[j + 1]);
			}
		}
		return minLen > n ? -1 : minLen;
	}
}
