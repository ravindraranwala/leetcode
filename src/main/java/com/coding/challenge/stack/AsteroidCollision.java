package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class AsteroidCollision {
	AsteroidCollision() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] asteroidsOne = { 5, 10, -5 };
		int[] ans = asteroidCollision(asteroidsOne);
		assert Arrays.equals(ans, new int[] { 5, 10 });

		final int[] asteroidsTwo = { 8, -8 };
		ans = asteroidCollision(asteroidsTwo);
		assert ans.length == 0;

		final int[] asteroidsThree = { 10, 2, -5 };
		ans = asteroidCollision(asteroidsThree);
		assert Arrays.equals(ans, new int[] { 10 });
	}

	static int[] asteroidCollision(int[] asteroids) {
		final int n = asteroids.length;
		final Deque<Integer> s = new ArrayDeque<>();
		s.push(-1); // default identity element.
		for (int i = 0; i < n; i++) {
			if (asteroids[i] > 0)
				s.push(asteroids[i]);
			else {
				final int size = Math.abs(asteroids[i]);
				while (s.peek() > 0 && s.peek() < size)
					s.pop();
				final int top = s.peek();
				if (top < 0)
					s.push(asteroids[i]);
				if (top == size)
					s.pop();
			}
		}
		final int c = s.size() - 1;
		final int[] answer = new int[c];
		for (int j = c - 1; j >= 0; j--)
			answer[j] = s.pop();

		return answer;

	}
}
