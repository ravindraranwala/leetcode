package com.coding.challenge.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GenerateParentheses {
	private static final char OPEN_BRACKET = '(';
	private static final char CLOSE_BRACKET = ')';

	GenerateParentheses() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
		System.out.println(generateParenthesis(2));
		System.out.println(generateParenthesis(1));
		System.out.println(generateParenthesis(4));
	}

	static List<String> generateParenthesis(int n) {
		final List<Set<String>> sln = new ArrayList<>();
		for (int j = 0; j <= n; j++)
			sln.add(new HashSet<>());

		sln.get(1).add("" + OPEN_BRACKET + CLOSE_BRACKET);
		for (int k = 2; k <= n; k++) {
			for (int i = 1; i < k; i++) {
				for (String p1 : sln.get(i)) {
					for (String p2 : sln.get(k - i)) {
						sln.get(k).add(p1 + p2);
					}
				}
			}

			for (String p : sln.get(k - 1))
				sln.get(k).add(OPEN_BRACKET + p + CLOSE_BRACKET);
		}

		return new ArrayList<>(sln.get(n));
	}
}
