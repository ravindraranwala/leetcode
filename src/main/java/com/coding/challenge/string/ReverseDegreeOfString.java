package com.coding.challenge.string;

class ReverseDegreeOfString {
	private static final char FIRST_LETTER = 'a';
	private static final int ALPHABET_SIZE = 26;

	ReverseDegreeOfString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert reverseDegree("abc") == 148;
		assert reverseDegree("zaza") == 160;
	}

	static int reverseDegree(String s) {
		final int n = s.length();
		int ans = 0;
		for (int i = 0; i < n; i++)
			ans = ans + (ALPHABET_SIZE - (s.charAt(i) - FIRST_LETTER)) * (i + 1);

		return ans;
	}
}
