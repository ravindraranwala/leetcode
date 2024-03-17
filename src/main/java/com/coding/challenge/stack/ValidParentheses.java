package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class ValidParentheses {
	ValidParentheses() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert isValid("()");
		assert isValid("()[]{}");
		assert !isValid("(]");
		assert !isValid("(({[}]))");
		assert isValid("{([{}()[]])}");
	}

	static boolean isValid(String s) {
		final Deque<Character> stack = new ArrayDeque<>();
		for (char ch : s.toCharArray()) {
			if (ch == '(' || ch == '[' || ch == '{')
				stack.push(ch);
			else {
				if (stack.isEmpty())
					return false;
				char lastOpenParens = '(';
				if (ch == ']')
					lastOpenParens = '[';
				else if (ch == '}')
					lastOpenParens = '{';
				if (stack.pop() != lastOpenParens)
					return false;
			}
		}
		return stack.isEmpty();
	}
}
