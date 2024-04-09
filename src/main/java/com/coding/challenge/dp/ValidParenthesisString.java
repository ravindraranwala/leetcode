package com.coding.challenge.dp;

class ValidParenthesisString {
	ValidParenthesisString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert checkValidString("()");
		assert checkValidString("(*)");
		assert checkValidString("(*))");
		assert !checkValidString(")");
		assert checkValidString("*()(*)(*)");
		assert checkValidString("()(*)(*)");
		assert checkValidString("((*)(*)");
	}

	static boolean checkValidString(String s) {
		final int n = s.length();
		final boolean[][] v = new boolean[n][n];
		// base cases.
		// i > j
		for (int i = 0; i < n; i++)
			for (int j = 0; j < i; j++)
				v[i][j] = true;
		// diagonal entries.
		for (int i = 0; i < n; i++)
			v[i][i] = s.charAt(i) == '*';

		// recursive step.
		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n - l + 1; i++) {
				final int j = i + l - 1;
				v[i][j] = (s.charAt(i) == '(' || s.charAt(i) == '*') && (s.charAt(j) == ')' || s.charAt(j) == '*')
						&& v[i + 1][j - 1];

				for (int k = i; k < j && !v[i][j]; k++)
					v[i][j] = v[i][k] && v[k + 1][j];
			}
		}
		return v[0][n - 1];
	}
}
