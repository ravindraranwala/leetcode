package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class VisiblePeopleInQueue {
	VisiblePeopleInQueue() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] heightsOne = { 10, 6, 8, 5, 11, 9 };
		assert Arrays.equals(new int[] { 3, 1, 2, 1, 1, 0 }, canSeePersonsCount(heightsOne));

		final int[] heightsTwo = { 5, 1, 2, 3, 10 };
		assert Arrays.equals(new int[] { 4, 1, 1, 1, 0 }, canSeePersonsCount(heightsTwo));
	}

	static int[] canSeePersonsCount(int[] heights) {
		final int n = heights.length;
		// monotonically decreasing stack.
		final Deque<Integer> s = new ArrayDeque<>();
		final int[] a = new int[n];

		for (int k = 0; k < n; k++) {
			while (!s.isEmpty() && heights[s.peek()] <= heights[k]) {
				final int j = s.pop();
				a[j] = a[j] + 1;
				if (!s.isEmpty()) {
					final int i = s.peek();
					a[i] = a[i] + 1;
				}
			}
			s.push(k);
		}

		// now consider the remaining elements in the stack.
		while (s.size() > 1) {
			s.pop();
			final int i = s.peek();
			a[i] = a[i] + 1;
		}

		return a;
	}
}
