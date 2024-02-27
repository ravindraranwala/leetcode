package com.coding.challenge.string;

class DetectCapital {
	DetectCapital() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert detectCapitalUse("USA");
		assert !detectCapitalUse("FlaG");
	}

	static boolean detectCapitalUse(String word) {
		int capitals = 0;
		for (char ch : word.toCharArray())
			if (Character.isUpperCase(ch))
				capitals = capitals + 1;

		return capitals == word.length() || capitals == 0 || (capitals == 1 && Character.isUpperCase(word.charAt(0)));
	}
}
