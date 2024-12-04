package com.coding.challenge.two.pointer;

class AddingSpacesToString {
	AddingSpacesToString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] spaces1 = { 8, 13, 15 };
		assert "Leetcode Helps Me Learn".equals(addSpaces("LeetcodeHelpsMeLearn", spaces1));

		final int[] spaces2 = { 1, 5, 7, 9 };
		assert "i code in py thon".equals(addSpaces("icodeinpython", spaces2));

		final int[] spaces3 = { 0, 1, 2, 3, 4, 5, 6 };
		assert " s p a c i n g".equals(addSpaces("spacing", spaces3));
	}

	static String addSpaces(String s, int[] spaces) {
		final int m = s.length();
		final int n = spaces.length;
		final char[] a = new char[m + n];

		for (int i = 0, j = 0; i < m; i++) {
			if (j < n && i == spaces[j]) {
				a[i + j] = ' ';
				j = j + 1;
			}
			a[i + j] = s.charAt(i);
		}
		return new String(a);
	}
}
