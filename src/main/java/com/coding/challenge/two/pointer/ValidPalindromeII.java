package com.coding.challenge.two.pointer;

class ValidPalindromeII {
	ValidPalindromeII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert validPalindrome("aba");
		assert validPalindrome("abca");
		assert !validPalindrome("abc");
	}

	static boolean validPalindrome(String s) {
		final int n = s.length();
		int i = 0;
		int j = n - 1;
		while (i < j && s.charAt(i) == s.charAt(j)) {
			i = i + 1;
			j = j - 1;
		}

		// no deletions required.
		if (i == j)
			return true;

		// one deletion required.
		return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
	}

	private static boolean isPalindrome(String s, int i, int j) {
		for (int k = i, l = j; k < l; k++, l--)
			if (s.charAt(k) != s.charAt(l))
				return false;
		return true;
	}
}
