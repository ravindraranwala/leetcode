package com.coding.challenge.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

class RemoveStones {
	RemoveStones() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] pilesOne = { 5, 4, 9 };
		assert minStoneSum(pilesOne, 2) == 12;

		final int[] pilesTwo = { 4, 3, 6, 7 };
		assert minStoneSum(pilesTwo, 3) == 12;
	}

	static int minStoneSum(int[] piles, int k) {
		final Queue<Integer> h = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
		int sum = 0;
		for (int val: piles) {
			sum = sum + val;
			h.add(val);
		}

		int c = 0;
		while (c < k) {
			final int largest = h.remove();
			sum = sum - largest / 2;
			h.add(largest - largest / 2);
			c = c + 1;
		}
		return sum;
	}
}
