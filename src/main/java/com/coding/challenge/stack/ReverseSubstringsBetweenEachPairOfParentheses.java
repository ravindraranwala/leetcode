package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class ReverseSubstringsBetweenEachPairOfParentheses {
	ReverseSubstringsBetweenEachPairOfParentheses() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		 assert "dcba".equals(reverseParentheses("(abcd)"));
		 assert "iloveu".equals(reverseParentheses("(u(love)i)"));
		 assert "leetcode".equals(reverseParentheses("(ed(et(oc))el)"));
	}

	static String reverseParentheses(String s) {
		final int n = s.length();
		final Deque<Integer> openingStack = new ArrayDeque<>();
		int bracketsCnt = 0;
		final char[] a = s.toCharArray();

		for (int j = 0; j < n; j++) {
			if (s.charAt(j) == '(')
				openingStack.push(j);
			else if (s.charAt(j) == ')') {
				final int i = openingStack.pop();
				bracketsCnt = bracketsCnt + 2;
				reverse(a, i, j);
			}
		}
		final char[] ans = new char[n - bracketsCnt];
		for (int i = 0, j = 0; j < n; j++) {
			final char ch = a[j];
			if (ch != '(' && ch != ')') {
				ans[i] = ch;
				i = i + 1;
			}
		}
		return String.valueOf(ans);
	}

	private static void reverse(char[] a, int i, int j) {
		while (i < j) {
			final char tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
			i = i + 1;
			j = j - 1;
		}
	}
}
