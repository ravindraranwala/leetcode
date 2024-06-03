package com.coding.challenge.two.pointer;

class AppendCharactersToStringToMakeSubsequence {
	AppendCharactersToStringToMakeSubsequence() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert appendCharacters("coaching", "coding") == 4;
		assert appendCharacters("abcde", "a") == 0;
		assert appendCharacters("z", "abcde") == 5;
	}

	static int appendCharacters(String s, String t) {
		final int m = s.length();
		final int n = t.length();
		int i = 0;
		int j = 0;
		while (i < n && j < m) {
			final char ch = t.charAt(i);
			while (j < m && s.charAt(j) != ch)
				j = j + 1;
			if (j < m) {
				i = i + 1;
				j = j + 1;
			}
		}
		return n - i;
	}
}
