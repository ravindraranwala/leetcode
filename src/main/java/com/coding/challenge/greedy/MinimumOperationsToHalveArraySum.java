package com.coding.challenge.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

class MinimumOperationsToHalveArraySum {
	MinimumOperationsToHalveArraySum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 5, 19, 8, 1 };
		assert halveArray(numsOne) == 3;

		final int[] numsTwo = { 3, 8, 20 };
		assert halveArray(numsTwo) == 3;
	}

	static int halveArray(int[] nums) {
		final Queue<Double> h = new PriorityQueue<>((a, b) -> Double.compare(b, a));
		long sum = 0;

		for (int val : nums) {
			sum = sum + val;
			h.add((double) val);
		}

		int c = 0;
		double reduced = 0;
		while (reduced < sum / 2.0) {
			final double largest = h.remove();
			reduced = reduced + largest / 2.0;
			h.add(largest / 2.0);
			c = c + 1;
		}

		return c;
	}
}
