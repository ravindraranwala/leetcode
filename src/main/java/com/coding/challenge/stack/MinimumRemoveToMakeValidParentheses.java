package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class MinimumRemoveToMakeValidParentheses {
	MinimumRemoveToMakeValidParentheses() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "lee(t(c)o)de".equals(minRemoveToMakeValid("lee(t(c)o)de)"));
		assert "ab(c)d".equals(minRemoveToMakeValid("a)b(c)d"));
		assert "".equals(minRemoveToMakeValid("))(("));
	}

	static String minRemoveToMakeValid(String s) {
		final int n = s.length();
		final Deque<Integer> stack = new ArrayDeque<>();
		final boolean[] removals = new boolean[n];
		int removedCnt = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(')
				stack.push(i);
			else if (s.charAt(i) == ')') {
				if (stack.isEmpty()) {
					removals[i] = true;
					removedCnt = removedCnt + 1;
				} else
					stack.pop();
			}
		}

		while (!stack.isEmpty()) {
			removals[stack.pop()] = true;
			removedCnt = removedCnt + 1;
		}

		final char[] ans = new char[n - removedCnt];
		for (int i = 0, curr = 0; i < n; i++) {
			if (!removals[i]) {
				ans[curr] = s.charAt(i);
				curr = curr + 1;
			}
		}
		return String.valueOf(ans);
	}
}
