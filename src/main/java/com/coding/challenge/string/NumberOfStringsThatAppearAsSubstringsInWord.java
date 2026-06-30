package com.coding.challenge.string;

class NumberOfStringsThatAppearAsSubstringsInWord {
	NumberOfStringsThatAppearAsSubstringsInWord() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] patterns1 = { "a", "abc", "bc", "d" };
		assert numOfStrings(patterns1, "abc") == 3;

		final String[] patterns2 = { "a", "b", "c" };
		assert numOfStrings(patterns2, "aaaaabbbbb") == 2;

		final String[] patterns3 = { "a", "a", "a" };
		assert numOfStrings(patterns3, "ab") == 3;
	}

	static int numOfStrings(String[] patterns, String word) {
		int cnt = 0;
		for (String token : patterns)
			if (word.contains(token))
				cnt = cnt + 1;

		return cnt;
	}
}
