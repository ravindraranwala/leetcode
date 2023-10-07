package com.coding.challenge.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

class MaximumProductAfterKIncrements {
	MaximumProductAfterKIncrements() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 0, 4 };
		assert maximumProduct(numsOne, 5) == 20;

		final int[] numsTwo = { 6, 3, 3, 2 };
		assert maximumProduct(numsTwo, 2) == 216;
	}

	static int maximumProduct(int[] nums, int k) {
		// min heap.
		final Queue<Integer> h = new PriorityQueue<>();
		for (int val : nums)
			h.add(val);

		for (int i = 0; i < k; i++)
			h.add(h.remove() + 1);

		int p = 1;
		while (!h.isEmpty())
			p = (int) (p * (long) h.remove() % 1000000007);

		return p;
	}
}
