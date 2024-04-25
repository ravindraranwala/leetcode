package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class MakeTheStringGreat {
	MakeTheStringGreat() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "leetcode".equals(makeGood("leEeetcode"));
		assert makeGood("abBAcC").isEmpty();
		assert "s".equals(makeGood("s"));
	}

	static String makeGood(String s) {
		final Deque<Character> stack = new ArrayDeque<>();
		// sentinel entry.
		stack.add('1');
		for (char ch : s.toCharArray()) {
			if (Character.isLowerCase(ch) && stack.peek() == Character.toUpperCase(ch))
				stack.pop();
			else if (Character.isUpperCase(ch) && stack.peek() == Character.toLowerCase(ch))
				stack.pop();
			else
				stack.push(ch);
		}
		final int n = stack.size() - 1;
		final char[] a = new char[n];
		for (int i = n - 1; i >= 0; i--)
			a[i] = stack.pop();

		return new String(a);
	}
}
