package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class ElementsGreaterThanVaryingThreshould {
	ElementsGreaterThanVaryingThreshould() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 3, 4, 3, 1 };
		assert validSubarraySize(numsOne, 6) == 3;

		final int[] numsTwo = { 6, 5, 6, 5, 8 };
		assert validSubarraySize(numsTwo, 7) == 5;
	}

	static int validSubarraySize(int[] nums, int threshold) {
		final int n = nums.length;
		final Deque<Integer> s = new ArrayDeque<>();
		s.push(-1);
		int l = -1;
		for (int i = 0; i < n; i++) {
			while (s.peek() != -1 && nums[s.peek()] >= nums[i]) {
				// min value of the window
				final int p = s.pop();
				final int ws = i - s.peek() - 1;
				if (nums[p] > threshold * 1.0 / ws)
					l = ws;
			}
			s.push(i);
		}

		// Now we have to take the remaining elements into account.
		while (s.peek() != -1) {
			// min value of the window
			final int p = s.pop();
			// use n in place of i
			final int ws = n - s.peek() - 1;
			if (nums[p] > threshold * 1.0 / ws)
				l = ws;
		}
		return l;
	}
}
