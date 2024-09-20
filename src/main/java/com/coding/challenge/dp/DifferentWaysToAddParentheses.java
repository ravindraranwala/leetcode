package com.coding.challenge.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DifferentWaysToAddParentheses {
	private static final char ZERO = '0';

	DifferentWaysToAddParentheses() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		System.out.println(diffWaysToCompute("1+2"));
		System.out.println(diffWaysToCompute("2-1-1"));
		System.out.println(diffWaysToCompute("2*3-4*5"));
	}

	static List<Integer> diffWaysToCompute(String expression) {
		final int n = expression.length();
		final IntList[][] t = new IntList[n][n];
		return diffWays(expression, 0, expression.length() - 1, t);
	}

	private static List<Integer> diffWays(String expression, int i, int j, IntList[][] t) {
		final int len = j - i + 1;
		// trivial case of the recursion.
		if (len == 1) {
			final List<Integer> ans = Arrays.asList(expression.charAt(i) - ZERO);
			// memoize the answer in the table.
			t[i][j] = new IntList(ans);
			return ans;
		}
		// trivial case of the recursion.
		if (len == 2) {
			final List<Integer> ans = Arrays
					.asList((expression.charAt(i) - ZERO) * 10 + expression.charAt(i + 1) - ZERO);
			// memoize the answer in the table.
			t[i][j] = new IntList(ans);
			return ans;
		}
		// answer already computed and stored in the table. Memoization.
		if (t[i][j] != null)
			return t[i][j].l;

		final List<Integer> ans = new ArrayList<>();
		for (int k = i; k <= j; k++) {
			final char ch = expression.charAt(k);
			// solve subproblems and then merge their solutions.
			if (ch == '*')
				multiply(diffWays(expression, i, k - 1, t), diffWays(expression, k + 1, j, t), ans);
			else if (ch == '+')
				addition(diffWays(expression, i, k - 1, t), diffWays(expression, k + 1, j, t), ans);
			else if (ch == '-')
				substraction(diffWays(expression, i, k - 1, t), diffWays(expression, k + 1, j, t), ans);
		}
		// memoize the answer in the table.
		t[i][j] = new IntList(ans);
		return ans;
	}

	private static void multiply(List<Integer> left, List<Integer> right, List<Integer> ans) {
		// cross product.
		for (int l : left)
			for (int r : right)
				ans.add(l * r);
	}

	private static void addition(List<Integer> left, List<Integer> right, List<Integer> ans) {
		// cross product.
		for (int l : left)
			for (int r : right)
				ans.add(l + r);
	}

	private static void substraction(List<Integer> left, List<Integer> right, List<Integer> ans) {
		// cross product.
		for (int l : left)
			for (int r : right)
				ans.add(l - r);
	}

	private static class IntList {
		private final List<Integer> l;

		IntList(List<Integer> l) {
			this.l = l;
		}
	}
}
