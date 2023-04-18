package com.coding.challenge.sliding.window;

class EqualSubstringsWithinBudget {

	EqualSubstringsWithinBudget() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert equalSubstring("abcd", "bcdf", 3) == 3;

		assert equalSubstring("abcd", "cdef", 3) == 1;

		assert equalSubstring("abcd", "acde", 0) == 1;
	}

	static int equalSubstring(String s, String t, int maxCost) {
		final int n = s.length();
		int l = 0;

		for (int i = 0, j = 0, cost = 0; j < n; j++) {
			cost = cost + Math.abs(s.charAt(j) - t.charAt(j));
			while (cost > maxCost) {
				cost = cost - Math.abs(s.charAt(i) - t.charAt(i));
				i = i + 1;
			}
			l = Math.max(l, j - i + 1);
		}
		return l;
	}
}
