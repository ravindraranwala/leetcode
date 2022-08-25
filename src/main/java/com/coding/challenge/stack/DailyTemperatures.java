package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class DailyTemperatures {
	DailyTemperatures() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] tmpOne = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] answer = dailyTemperatures(tmpOne);
		final int[] expOne = { 1, 1, 4, 2, 1, 1, 0, 0 };
		assert Arrays.equals(answer, expOne);

		final int[] tmpTwo = { 30, 40, 50, 60 };
		answer = dailyTemperatures(tmpTwo);
		final int[] expTwo = { 1, 1, 1, 0 };
		assert Arrays.equals(answer, expTwo);

		final int[] tmpThree = { 30, 60, 90 };
		answer = dailyTemperatures(tmpThree);
		final int[] expThree = { 1, 1, 0 };
		assert Arrays.equals(answer, expThree);
	}

	static int[] dailyTemperatures(int[] temperatures) {
		final int n = temperatures.length;
		final int[] answer = new int[n];
		// initializing explicitly.
		for (int i = 0; i < n; i++)
			answer[i] = 0;

		final Deque<Integer> tmp = new ArrayDeque<>();
		final Deque<Integer> pos = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			while (!tmp.isEmpty() && temperatures[i] > tmp.peek()) {
				tmp.pop();
				final int idx = pos.pop();
				answer[idx] = i - idx;
			}
			tmp.push(temperatures[i]);
			pos.push(i);
		}
		// remaining elements in the stack has no successors higher than it. Thus, the
		// answer is 0.
		return answer;
	}
}
