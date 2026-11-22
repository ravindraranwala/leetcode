package com.coding.challenge.string;

class CheckIfAllAsAppearsBeforeAllBs {
	private static final char A = 'a';

	CheckIfAllAsAppearsBeforeAllBs() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert checkString("aaabbb");
		assert !checkString("abab");
		assert checkString("bbb");
	}

	static boolean checkString(String s) {
		final int n = s.length();
		int lastA = -1;
		int firstB = n;
		for (int i = 0; i < n; i++)
			if (s.charAt(i) == A)
				lastA = i;

		for (int j = n - 1; j >= 0; j--)
			if (s.charAt(j) != A)
				firstB = j;

		return lastA < firstB;
	}
}
