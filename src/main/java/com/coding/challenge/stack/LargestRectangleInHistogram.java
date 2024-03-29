package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
	LargestRectangleInHistogram() {
		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {
		final int[] heightsOne = { 2, 1, 5, 6, 2, 3 };
		assert largestRectangleArea(heightsOne) == 10;

		final int[] heightTwo = { 2, 4 };
		assert largestRectangleArea(heightTwo) == 4;

		final int[] heightThree = { 5, 4, 1, 2 };
		assert largestRectangleArea(heightThree) == 8;

		final int[] heightFour = { 5, 4, 3, 7, 2 };
		assert largestRectangleArea(heightFour) == 12;
	}

	public static int largestRectangleArea(int[] heights) {
		final int n = heights.length;
		// monotonically increasing stack
		final Deque<Integer> s = new ArrayDeque<>();
		// a default value avoids additional conditional if check.
		s.push(-1);
		int r = 0;

		for (int i = 0; i < n; i++) {
			while (s.peek() != -1 && heights[s.peek()] >= heights[i]) {
				final int j = s.pop();
				final int k = s.peek();
				r = Math.max(r, (i - k - 1) * heights[j]);
			}
			s.push(i);
		}

		// Now we have to take the remaining elements into account.
		// the stack should have the last element at the top now
		while (s.peek() != -1) {
			final int j = s.pop();
			final int k = s.peek();
			r = Math.max(r, (n - k - 1) * heights[j]);
		}
		return r;
	}
}
