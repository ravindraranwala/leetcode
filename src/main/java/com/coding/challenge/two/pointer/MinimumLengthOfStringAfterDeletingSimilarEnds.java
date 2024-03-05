package com.coding.challenge.two.pointer;

class MinimumLengthOfStringAfterDeletingSimilarEnds {
	MinimumLengthOfStringAfterDeletingSimilarEnds() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minimumLength("ca") == 2;
		assert minimumLength("cabaabac") == 0;
		assert minimumLength("aabccabba") == 3;
		assert minimumLength("a") == 1;
		assert minimumLength("aaaaaaa") == 0;
	}

	static int minimumLength(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j && s.charAt(i) == s.charAt(j)) {
			final char ch = s.charAt(i);
			while (i < j && s.charAt(i) == ch)
				i = i + 1;
			while (i <= j && s.charAt(j) == ch)
				j = j - 1;
		}
		return j - i + 1;
	}
}
