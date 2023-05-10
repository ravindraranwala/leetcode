package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class ValidateStackSequences {
	ValidateStackSequences() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] pushedOne = { 1, 2, 3, 4, 5 };
		final int[] poppedOne = { 4, 5, 3, 2, 1 };
		assert validateStackSequences(pushedOne, poppedOne);

		final int[] pushedTwo = { 1, 2, 3, 4, 5 };
		final int[] poppedTwo = { 4, 3, 5, 1, 2 };
		assert !validateStackSequences(pushedTwo, poppedTwo);
	}

	static boolean validateStackSequences(int[] pushed, int[] popped) {
		final Deque<Integer> s = new ArrayDeque<>();
		int i = 0;
		for (int val : pushed) {
			s.push(val);
			while (!s.isEmpty() && s.peek() == popped[i]) {
				s.pop();
				i = i + 1;
			}
		}
		return s.isEmpty();
	}
}
