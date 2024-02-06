package com.coding.challenge.hash.table;

class ValidAnagram {
	private static final char FIRST_LETTER = 'a';

	ValidAnagram() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert isAnagram("anagram", "nagaram");
	}

	static boolean isAnagram(String s, String t) {
		final int[] f1 = new int[26];
		for (char ch : s.toCharArray())
			f1[ch - FIRST_LETTER] = f1[ch - FIRST_LETTER] + 1;

		final int[] f2 = new int[26];
		for (char ch : t.toCharArray())
			f2[ch - FIRST_LETTER] = f2[ch - FIRST_LETTER] + 1;

		boolean valid = true;
		for (int i = 0; i < 16; i++)
			valid = valid && f1[i] == f2[i];
		return valid;
	}
}
