package com.coding.challenge.dp;

import java.util.ArrayDeque;
import java.util.Deque;

class LongestValidParentheses {
	private static final char OPEN_BRACKET = '(';

	LongestValidParentheses() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert longestValidParentheses("(()") == 2;
		assert longestValidParentheses(")()())") == 4;
		assert longestValidParentheses("") == 0;
	}

	static int longestValidParentheses(String s) {
		final int n = s.length();
		int maxLen = 0;
		final int[] len = new int[n];
		final Deque<Integer> stack = new ArrayDeque<>();
		for (int j = 0; j < n; j++) {
			final char ch = s.charAt(j);
			if (ch == OPEN_BRACKET)
				stack.push(j);
			else if (!stack.isEmpty()) {
				final int i = stack.pop();
				if (i == 0)
					len[j] = j + 1;
				else
					len[j] = len[i - 1] + j - i + 1;

				maxLen = Math.max(maxLen, len[j]);
			}
		}
		return maxLen;
	}
}
