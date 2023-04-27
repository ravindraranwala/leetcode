package com.coding.challenge.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

class MaximalScoreAfterApplyingKOperations {
	MaximalScoreAfterApplyingKOperations() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 10, 10, 10, 10, 10 };
		assert maxKelements(numsOne, 5) == 50;

		final int[] numsTwo = { 1, 10, 3, 3, 3 };
		assert maxKelements(numsTwo, 3) == 17;
	}

	static long maxKelements(int[] nums, int k) {
		final Queue<Integer> h = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
		for (int val : nums)
			h.add(val);

		long score = 0;
		int c = 0;
		while (c < k) {
			final int v = h.remove();
			score = score + v;
			h.add((int) Math.ceil(v / 3.0));
			c = c + 1;
		}

		return score;
	}
}
