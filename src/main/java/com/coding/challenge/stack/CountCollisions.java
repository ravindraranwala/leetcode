package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class CountCollisions {
	private static final char STAYING = 'S';
	private static final char RIGHT = 'R';
	private static final char LEFT = 'L';

	CountCollisions() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert countCollisions("RLRSLL") == 5;

		assert countCollisions("LLRR") == 0;
	}

	static int countCollisions(String directions) {
		final int n = directions.length();
		final Deque<Character> s = new ArrayDeque<>();
		int c = 0;
		s.push(directions.charAt(0));
		for (int i = 1; i < n; i++) {
			if (directions.charAt(i) == LEFT) {
				if (s.peek() == STAYING)
					c = c + 1;
				if (s.peek() == RIGHT) {
					c = c + 2;
					s.pop();
					// all these Rs collide with our new S.
					while (!s.isEmpty() && s.peek() == RIGHT) {
						c = c + 1;
						s.pop();
					}
					s.push(STAYING);
				}

			} else if (directions.charAt(i) == STAYING) {
				// all these Rs collide with our new S.
				while (!s.isEmpty() && s.peek() == RIGHT) {
					c = c + 1;
					s.pop();
				}
				s.push(directions.charAt(i));
			} else
				s.push(directions.charAt(i));
		}
		return c;
	}
}
