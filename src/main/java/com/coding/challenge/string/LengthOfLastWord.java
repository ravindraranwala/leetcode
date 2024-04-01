package com.coding.challenge.string;

class LengthOfLastWord {
	LengthOfLastWord() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert lengthOfLastWord("Hello World") == 5;
		assert lengthOfLastWord("   fly me   to   the moon  ") == 4;
		assert lengthOfLastWord("luffy is still joyboy") == 6;
	}

	static int lengthOfLastWord(String s) {
		int j = s.length() - 1;
		while (s.charAt(j) == ' ')
			j = j - 1;

		int i = j;
		while (i >= 0 && s.charAt(i) != ' ')
			i = i - 1;
		return j - i;
	}
}
