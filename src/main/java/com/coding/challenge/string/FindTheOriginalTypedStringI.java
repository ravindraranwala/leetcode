package com.coding.challenge.string;

class FindTheOriginalTypedStringI {
	FindTheOriginalTypedStringI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert possibleStringCount("abbcccc") == 5;
		assert possibleStringCount("abcd") == 1;
		assert possibleStringCount("aaaa") == 4;
	}

	static int possibleStringCount(String word) {
		final int n = word.length();
		int ans = 1;
		for (int i = 1; i < n; i++)
			if (word.charAt(i) == word.charAt(i - 1))
				ans = ans + 1;

		return ans;
	}
}
