package com.coding.challenge.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class RestoreArrayFromPairs {
	RestoreArrayFromPairs() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] adjPairsOne = { { 2, 1 }, { 3, 4 }, { 3, 2 } };
		System.out.println(Arrays.toString(restoreArray(adjPairsOne)));

		final int[][] adjPairsTwo = { { 4, -2 }, { 1, 4 }, { -3, 1 } };
		System.out.println(Arrays.toString(restoreArray(adjPairsTwo)));

		final int[][] adjPairsThree = { { 100000, -100000 } };
		System.out.println(Arrays.toString(restoreArray(adjPairsThree)));
	}

	static int[] restoreArray(int[][] adjacentPairs) {
		final Map<Integer, List<Integer>> pairs = new HashMap<>();
		for (int[] p : adjacentPairs) {
			pairs.computeIfAbsent(p[0], unused -> new LinkedList<>()).add(p[1]);
			pairs.computeIfAbsent(p[1], unused -> new LinkedList<>()).add(p[0]);
		}

		int currVal = Integer.MIN_VALUE;
		for (Entry<Integer, List<Integer>> e : pairs.entrySet())
			if (e.getValue().size() == 1)
				currVal = e.getKey();

		final int n = adjacentPairs.length + 1;
		final int[] nums = new int[n];
		for (int i = 0; i < n - 1; i++) {
			nums[i] = currVal;
			final int nextVal = pairs.get(currVal).get(0);
			pairs.get(nextVal).remove((Integer) currVal);
			currVal = nextVal;
		}
		nums[n - 1] = currVal;
		return nums;
	}
}