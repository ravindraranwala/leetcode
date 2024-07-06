package com.coding.challenge.dp;

import java.util.ArrayDeque;
import java.util.Deque;

class LongestValidParentheses {
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
		final int[] l = new int[n];
		final Deque<Integer> openingStack = new ArrayDeque<>();
		int maxLen = 0;

		for (int j = 0; j < n; j++) {
			if (s.charAt(j) == '(')
				openingStack.push(j);
			else if (!openingStack.isEmpty()) {
				final int i = openingStack.pop();
				if (i == 0)
					l[j] = j - i + 1;
				else
					l[j] = l[i - 1] + j - i + 1;
				maxLen = Math.max(maxLen, l[j]);
			}
		}
		return maxLen;
	}
}
