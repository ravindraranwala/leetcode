package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class ClearDigits {
	ClearDigits() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "abc".equals(clearDigits("abc"));
		assert "".equals(clearDigits("cb34"));
	}

	static String clearDigits(String s) {
		final int n = s.length();
		final Deque<Character> stack = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			final char ch = s.charAt(i);
			if (Character.isDigit(ch))
				stack.pop();
			else
				stack.push(ch);
		}

		// constructing the solution.
		final int m = stack.size();
		final char[] a = new char[m];
		for (int i = 0; i < m; i++)
			a[i] = stack.pollLast();

		return new String(a);
	}
}
