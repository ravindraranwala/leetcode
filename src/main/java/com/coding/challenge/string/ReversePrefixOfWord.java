package com.coding.challenge.string;

class ReversePrefixOfWord {
	ReversePrefixOfWord() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "dcbaefd".equals(reversePrefix("abcdefd", 'd'));
		assert "zxyxxe".equals(reversePrefix("xyxzxe", 'z'));
		assert "abcd".equals(reversePrefix("abcd", 'z'));
	}

	static String reversePrefix(String word, char ch) {
		final int n = word.length();
		int k = -1;
		for (int i = 0; i < n && k == -1; i++)
			if (word.charAt(i) == ch)
				k = i;

		final char[] a = word.toCharArray();
		for (int j = 0, m = (k + 1) / 2; j < m; j++) {
			// swap two letters.
			final char tmp = a[j];
			a[j] = a[k - j];
			a[k - j] = tmp;
		}
		return new String(a);
	}
}
