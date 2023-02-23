package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class MinCostTreeFromLeafValues {
	MinCostTreeFromLeafValues() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] treeOne = { 6, 2, 4 };
		assert mctFromLeafValues(treeOne) == 32;

		final int[] treeTwo = { 4, 11 };
		assert mctFromLeafValues(treeTwo) == 44;

		final int[] treeThree = { 5, 4, 1, 3, 2 };
		assert mctFromLeafValues(treeThree) == 41;

		final int[] treeFour = { 1, 2, 3, 4, 5 };
		assert mctFromLeafValues(treeFour) == 40;

		final int[] treeFive = { 15, 13, 5, 3, 15 };
		assert mctFromLeafValues(treeFive) == 500;
	}

	static int mctFromLeafValues(int[] arr) {
		final Deque<Integer> s = new ArrayDeque<>();
		int cost = 0;
		final int n = arr.length;
		for (int i = 0; i < n; i++) {
			int prev = 0;
			while (!s.isEmpty() && s.peek() <= arr[i]) {
				final int curr = s.pop();
				cost = cost + curr * prev;
				prev = curr;
			}
			cost = cost + prev * arr[i];
			s.push(arr[i]);
		}

		while (s.size() > 1)
			cost = cost + s.pop() * s.peek();
		return cost;
	}
}
