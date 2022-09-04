package com.coding.challenge.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class SlidingWindowMax {
	SlidingWindowMax() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 3, -1, -3, 5, 3, 6, 7 };
		assert Arrays.equals(maxSlidingWindow(numsOne, 3), new int[] { 3, 3, 5, 5, 6, 7 });

		final int[] numsTwo = { 1 };
		assert Arrays.equals(maxSlidingWindow(numsTwo, 1), new int[] { 1 });
	}

	static int[] maxSlidingWindow(int[] nums, int k) {
		final int n = nums.length;
		// we use a queue over stack since it is much more readable.
		final Deque<Integer> q = new ArrayDeque<>();
		final int[] ans = new int[n - k + 1];
		// populate the initial window
		for (int i = 0; i < k; i++) {
			while (!q.isEmpty() && q.peekLast() < nums[i])
				q.pollLast();

			q.add(nums[i]);
		}

		ans[0] = q.peek();
		// j is our window starting position.
		for (int j = 1; j <= n - k; j++) {
			// remove the 1st element of the previous window if it is not already removed
			if (q.element() == nums[j - 1])
				q.remove();

			while (!q.isEmpty() && q.peekLast() < nums[j + k - 1])
				q.pollLast();

			q.add(nums[j + k - 1]);
			ans[j] = q.peek();
		}
		return ans;
	}
}
