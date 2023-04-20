package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class SubarraysWithBoundedMaximum {
	SubarraysWithBoundedMaximum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 2, 1, 4, 3 };
		assert numSubarrayBoundedMax(numsOne, 2, 3) == 3;

		final int[] numsTwo = { 2, 9, 2, 5, 6 };
		assert numSubarrayBoundedMax(numsTwo, 2, 8) == 7;
	}

	static int numSubarrayBoundedMax(int[] nums, int left, int right) {
		final int n = nums.length;
		// Monotonically decreasing stack.
		final Deque<Integer> s = new ArrayDeque<>();
		s.push(-1);
		int c = 0;

		for (int i = 0, l = 0; i < n; i++) {
			while (s.peek() != -1 && nums[s.peek()] < nums[i]) {
				final int j = s.pop();
				if (left <= nums[j] && nums[j] <= right)
					l = l - (j - s.peek());
			}
			if (left <= nums[i] && nums[i] <= right)
				l = l + (i - s.peek());
			c = c + l;
			s.push(i);
		}
		return c;
	}
}
