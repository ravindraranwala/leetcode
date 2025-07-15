package com.coding.challenge.string;

class ValidWord {
	private static final char LOWER_FIRST_LETTER = 'a';
	private static final char UPPER_FIRST_LETTER = 'A';
	private static final char ZERO = '0';

	ValidWord() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert isValid("234Adas");
		assert !isValid("b3");
		assert !isValid("a3$e");
	}

	static boolean isValid(String word) {
		boolean vowel = false;
		boolean consonant = false;
		for (char ch : word.toCharArray()) {
			if (ch - LOWER_FIRST_LETTER >= 0 && ch - LOWER_FIRST_LETTER < 26) {
				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
					vowel = true;
				else
					consonant = true;
			} else if (ch - UPPER_FIRST_LETTER >= 0 && ch - UPPER_FIRST_LETTER < 26) {
				if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
					vowel = true;
				else
					consonant = true;
			} else if (ch - ZERO < 0 || ch - ZERO > 9)
				return false;
		}
		return word.length() >= 3 && vowel && consonant;
	}
}
