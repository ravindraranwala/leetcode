package com.coding.challenge.hash.table;

class MaximumNumberOfWordsYouCanType {
	private static final char FIRST_LETTER = 'a';

	MaximumNumberOfWordsYouCanType() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert canBeTypedWords("hello world", "ad") == 1;
		assert canBeTypedWords("leet code", "lt") == 1;
		assert canBeTypedWords("leet code", "e") == 0;
	}

	static int canBeTypedWords(String text, String brokenLetters) {
		// init.
		final boolean[] broken = new boolean[26];
		for (char ch : brokenLetters.toCharArray())
			broken[ch - FIRST_LETTER] = true;

		int c = 0;
		boolean canType = true;
		for (char ch : text.toCharArray()) {
			if (ch == ' ') {
				if (canType)
					c = c + 1;

				canType = true;
			} else if (broken[ch - FIRST_LETTER])
				canType = false;
		}
		// take the last word into account.
		if (canType)
			c = c + 1;

		return c;
	}
}
