package com.coding.challenge.two.pointer;

class ValidPalindrome {
	ValidPalindrome() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert isPalindrome("A man, a plan, a canal: Panama");
		assert !isPalindrome("race a car");
		assert isPalindrome(" ");
		assert isPalindrome("aa");
	}

	static boolean isPalindrome(String s) {
		final StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray())
			if (Character.isDigit(ch) || Character.isLetter(ch))
				sb.append(Character.toLowerCase(ch));

		final String alphaNumericStr = sb.toString();
		if (alphaNumericStr.isEmpty())
			return true;
		int i = 0;
		int j = alphaNumericStr.length() - 1;
		while (i < j && alphaNumericStr.charAt(i) == alphaNumericStr.charAt(j)) {
			i = i + 1;
			j = j - 1;
		}

		return i >= j;
	}
}
