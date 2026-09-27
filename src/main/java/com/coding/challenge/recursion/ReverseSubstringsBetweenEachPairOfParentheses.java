package com.coding.challenge.recursion;

class ReverseSubstringsBetweenEachPairOfParentheses {
	private static final char OPEN_BRACKET = '(';
	private static final char CLOSE_BRACKET = ')';

	ReverseSubstringsBetweenEachPairOfParentheses() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "dcba".equals(reverseParentheses("(abcd)"));
		assert "iloveu".equals(reverseParentheses("(u(love)i)"));
		assert "leetcode".equals(reverseParentheses("(ed(et(oc))el)"));
		assert "mnkjirqpdecba".equals(reverseParentheses("(abc(de)pqr(mn(ijk)"));
	}

	static String reverseParentheses(String s) {
		return new StringBuilder(parse(s, 0, new int[1])).reverse().toString();
	}

	private static String parse(String s, int i, int[] idx) {
		final int n = s.length();
		final StringBuilder ans = new StringBuilder();
		int j = i;
		while (j < n && s.charAt(j) != CLOSE_BRACKET) {
			if (s.charAt(j) == OPEN_BRACKET) {
				ans.append(parse(s, j + 1, idx));
				j = idx[0];
			} else {
				ans.append(s.charAt(j));
				j = j + 1;
			}
		}
		idx[0] = Math.min(j + 1, n);
		return ans.reverse().toString();
	}
}
