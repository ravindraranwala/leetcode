package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class MinimumStringLengthAfterRemovingSubstrings {
	MinimumStringLengthAfterRemovingSubstrings() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minLength("ABFCACDB") == 2;
		assert minLength("ACBBD") == 5;
		assert minLength("D") == 1;
	}

	static int minLength(String s) {
		final Deque<Character> stack = new ArrayDeque<>();
		for (char ch : s.toCharArray()) {
			if (ch == 'B' && !stack.isEmpty() && stack.peek() == 'A')
				stack.pop();
			else if (ch == 'D' && !stack.isEmpty() && stack.peek() == 'C')
				stack.pop();
			else
				stack.push(ch);
		}
		return stack.size();
	}
}
