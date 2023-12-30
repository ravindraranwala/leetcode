package com.coding.challenge.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GenerateParentheses {
	GenerateParentheses() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final Set<String> s3 = new HashSet<>(Arrays.asList("()()()", "(()())", "()(())", "((()))", "(())()"));
		assert s3.equals(new HashSet<>(generateParenthesis(3)));

		final Set<String> s1 = new HashSet<String>(Arrays.asList("()"));
		assert s1.equals(new HashSet<>(generateParenthesis(1)));
		final Set<String> s4 = new HashSet<>(
				Arrays.asList("(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())", "(()())()",
						"(())(())", "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()"));
		assert s4.equals(new HashSet<>(generateParenthesis(4)));

	}

	static List<String> generateParenthesis(int n) {
		final Set<String> s = new HashSet<>();
		backtrack(n * 2, s, new char[n * 2], 0, 0);
		return new ArrayList<>(s);
	}

	private static void backtrack(int n, Set<String> s, char[] p, int open, int closed) {
		// not a well-formed parentheses string.
		if (closed > open)
			return;
		// trivial case of the recursion.
		if (n == 0) {
			// is it a well-formed parentheses string?
			if (open == closed)
				s.add(new String(p));
			return;
		}

		final int l = p.length;
		// choose.
		p[l - n] = '(';
		// explore.
		backtrack(n - 1, s, p, open + 1, closed);
		// unchoose and then choose.
		p[l - n] = ')';
		// explore.
		backtrack(n - 1, s, p, open, closed + 1);
	}

	/**
	 * Utility method to check whether a given string is a well formed parentheses.
	 * 
	 * @param s input string containing parentheses
	 * @return <code>true</code> if it is well formed parentheses,
	 *         <code>false</code> otherwise.
	 */
	private static boolean wellFormedParens(String s) {
		int open = 0;
		int closed = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '(')
				open = open + 1;
			if (ch == ')')
				closed = closed + 1;
			if (closed > open)
				return false;
		}
		return open == closed && open + closed == s.length();
	}
}
