package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class SumOfSubarrMinimums {
	private static final int MOD = 1000000007;

	SumOfSubarrMinimums() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arrOne = { 3, 1, 2, 4 };
		assert sumSubarrayMins(arrOne) == 17;

		final int[] arrTwo = { 11, 81, 94, 43, 3 };
		assert sumSubarrayMins(arrTwo) == 444;

		final int[] arrThree = { 71, 55, 82, 55 };
		assert sumSubarrayMins(arrThree) == 593;
	}

	static int sumSubarrayMins(int[] arr) {
		final int n = arr.length;
		// monotonically increasing stack.
		final Deque<Integer> s = new ArrayDeque<>();
		s.push(-1);
		int sum = 0;
		for (int i = 0, last = 0; i < n; i++) {
			while (s.size() > 1 && arr[s.peek()] > arr[i]) {
				final int j = s.pop();
				last = last - arr[j] * (j - s.peek());
			}
			last = last + arr[i] * (i - s.peek());
			sum = (sum + last) % MOD;
			s.push(i);
		}
		return sum;
	}
}
