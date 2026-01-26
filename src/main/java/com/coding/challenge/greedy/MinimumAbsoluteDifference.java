package com.coding.challenge.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MinimumAbsoluteDifference {
	MinimumAbsoluteDifference() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 4, 2, 1, 3 };
		System.out.println(minimumAbsDifference(arr1));

		final int[] arr2 = { 1, 3, 6, 10, 15 };
		System.out.println(minimumAbsDifference(arr2));

		final int[] arr3 = { 3, 8, -10, 23, 19, -4, -14, 27 };
		System.out.println(minimumAbsDifference(arr3));
	}

	static List<List<Integer>> minimumAbsDifference(int[] arr) {
		final int n = arr.length;
		Arrays.sort(arr);
		int minDiff = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++)
			minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);

		final List<List<Integer>> l = new ArrayList<>();
		for (int i = 1; i < n; i++)
			if (arr[i] - arr[i - 1] == minDiff)
				l.add(Arrays.asList(arr[i - 1], arr[i]));

		return l;
	}
}
