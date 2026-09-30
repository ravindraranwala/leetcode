package com.coding.challenge.stack;

import java.util.Arrays;

class MaximumNestingDepthOfTwoValidParenthesesStrings {
	private static final char OPEN_BRACKET = '(';
	private static final char CLOSE_BRACKET = ')';

	MaximumNestingDepthOfTwoValidParenthesesStrings() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(maxDepthAfterSplit("(()())")));
		System.out.println(Arrays.toString(maxDepthAfterSplit("()(())()")));
	}

	static int[] maxDepthAfterSplit(String seq) {
		final int n = seq.length();
		final int[] a = new int[n];
		final int d = MaximumNestingDepthOfTheParentheses.maxDepth(seq);
		if (d == 1) {
			a[0] = 1;
			a[1] = 1;
			return a;
		}

		for (int i = 0, currDepth = 0; i < n; i++) {
			final char ch = seq.charAt(i);
			if (ch == OPEN_BRACKET) {
				currDepth = currDepth + 1;
				if (currDepth <= d / 2)
					a[i] = 1;
			} else if (ch == CLOSE_BRACKET) {
				if (currDepth <= d / 2)
					a[i] = 1;

				currDepth = currDepth - 1;
			}
		}
		return a;
	}
}
