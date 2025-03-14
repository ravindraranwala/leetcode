package com.coding.challenge.string;

class CountPrefixAndSuffixPairsI {
	CountPrefixAndSuffixPairsI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] words1 = { "a", "aba", "ababa", "aa" };
		assert countPrefixSuffixPairs(words1) == 4;

		final String[] words2 = { "pa", "papa", "ma", "mama" };
		assert countPrefixSuffixPairs(words2) == 2;

		final String[] words3 = { "abab", "ab" };
		assert countPrefixSuffixPairs(words3) == 0;

		final String[] words4 = { "a", "abb" };
		assert countPrefixSuffixPairs(words4) == 0;
	}

	static int countPrefixSuffixPairs(String[] words) {
		final int n = words.length;
		int c = 0;
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if (isPrefixAndSuffix(words[i], words[j]))
					c = c + 1;
		return c;
	}

	private static boolean isPrefixAndSuffix(String str1, String str2) {
		if (str1.length() > str2.length())
			return false;
		final int n = str1.length();
		final int m = str2.length();
		for (int i = 0; i < n; i++)
			if (str1.charAt(n - i - 1) != str2.charAt(m - i - 1) || str1.charAt(i) != str2.charAt(i))
				return false;

		return true;
	}
}
