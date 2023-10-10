package com.coding.challenge.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

class MakeArrayEmpty {
	MakeArrayEmpty() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arrOne = { 1, 1, 3, 2, 3 };
		assert minOperations(arrOne) == 2;

		final int[] arrTwo = { 1, 1, 3, 5 };
		assert minOperations(arrTwo) == 3;

		final int[] arrThree = { 1, 1, 2, 3, 4, 5 };
		assert minOperations(arrThree) == 1;

		final int[] arrFour = { 1, 1, 1, 1 };
		assert minOperations(arrFour) == 1;

		final int[] arrFive = { 1, 1, 2, 4, 5 };
		assert minOperations(arrFive) == 3;

		final int[] arrSix = { 1, 1, 2, 4, 5, 5, 6 };
		assert minOperations(arrSix) == 3;

		final int[] arrSeven = { 1, 2, 3, 4, 5 };
		assert minOperations(arrSeven) == 5;
		
		final int[] arrEight = {0, 0, 0, 0};
		assert minOperations(arrEight) == 1;
	}

	static int minOperations(int[] arr) {
		final Queue<Integer> h = new PriorityQueue<>();
		for (int v : arr)
			h.add(v);

		int steps = 1;
		while (h.size() > 1) {
			final int a = h.remove();
			final int b = h.peek();
			if (a == b) {
				h.remove();
				h.add(a + 1);
			} else
				steps = steps + 1;
		}
		return steps;
	}
}
