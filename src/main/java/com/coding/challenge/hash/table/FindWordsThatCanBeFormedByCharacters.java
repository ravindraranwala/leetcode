package com.coding.challenge.hash.table;

class FindWordsThatCanBeFormedByCharacters {
	private static final char FIRST_LETTER = 'a';

	FindWordsThatCanBeFormedByCharacters() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] words = { "cat", "bt", "hat", "tree" };
		assert countCharacters(words, "atach") == 6;
	}

	static int countCharacters(String[] words, String chars) {
		final int[] charsFreq = new int[26];
		for (char ch : chars.toCharArray())
			charsFreq[ch - FIRST_LETTER] = charsFreq[ch - FIRST_LETTER] + 1;

		int l = 0;
		for (String word : words) {
			final int[] wordFreq = new int[26];
			boolean good = true;
			for (char ch : word.toCharArray()) {
				wordFreq[ch - FIRST_LETTER] = wordFreq[ch - FIRST_LETTER] + 1;
				good = good && wordFreq[ch - FIRST_LETTER] <= charsFreq[ch - FIRST_LETTER];
			}

			if (good)
				l = l + word.length();
		}
		return l;
	}
}
