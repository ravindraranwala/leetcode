package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class MaxScoreGoodSubarray {
	MaxScoreGoodSubarray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 4, 3, 7, 4, 5 };
		int score = maximumScore(numsOne, 3);
		System.out.println(score);

		final int[] numsTwo = { 5, 5, 4, 5, 4, 1, 1, 1 };
		score = maximumScore(numsTwo, 0);
		System.out.println(score);

		final int[] numsThree = { 4 };
		score = maximumScore(numsThree, 0);
		System.out.println(score);
	}

	static int maximumScore(int[] nums, int k) {
		final int n = nums.length;
		// monotonically increasing stack
		final Deque<Integer> s = new ArrayDeque<>();
		final Deque<Integer> p = new ArrayDeque<>();
		// a default value avoids additional conditional if check.
		p.push(-1);
		int r = 0;

		for (int i = 0; i < n; i++) {
			while (!s.isEmpty() && s.peek() >= nums[i]) {
				p.pop();
				final int j = p.peek();
				final int h = s.pop();
				if (j < k && k < i) 
					r = Math.max(r, (i - j - 1) * h);
			}
			s.push(nums[i]);
			p.push(i);
		}

		// Now we have to take the remaining elements into account.
		// the stack should have the last element at the top now
		while (!s.isEmpty()) {
			p.pop();
			final int j = p.peek();
			final int h = s.pop();
			if (j < k)
				r = Math.max(r, (n - j - 1) * h);
		}
		return r;
	}
}
