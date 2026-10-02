package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class ValidParentheses {
	private static final char OPEN_PARENTHESES = '(';
	private static final char CLOSE_PARENTHESES = ')';
	private static final char OPEN_CURLY_BRACE = '{';
	private static final char CLOSE_CURLY_BRACE = '}';
	private static final char OPEN_SQUARE_BRACKET = '[';
	private static final char CLOSE_SQUARE_BRACKET = ']';

	ValidParentheses() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert isValid("()");
		assert isValid("()[]{}");
		assert !isValid("(]");
		assert isValid("([])");
		assert !isValid("([)]");
	}

	static boolean isValid(String s) {
        final Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
        	if (ch == OPEN_PARENTHESES || ch == OPEN_CURLY_BRACE || ch == OPEN_SQUARE_BRACKET)
        		stack.push(ch);
        	else if (ch == CLOSE_PARENTHESES && !stack.isEmpty() && stack.peek() == OPEN_PARENTHESES)
        		stack.pop();
        	else if (ch == CLOSE_CURLY_BRACE && !stack.isEmpty() && stack.peek() == OPEN_CURLY_BRACE)
        		stack.pop();
        	else if (ch == CLOSE_SQUARE_BRACKET && !stack.isEmpty() && stack.peek() == OPEN_SQUARE_BRACKET)
        		stack.pop();
        	else
        		return false;
        }
        return stack.isEmpty();
    }
}
