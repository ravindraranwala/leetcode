package com.coding.challenge.string;

class WeightedWordMapping {
	private static final char FIRST_LETTER = 'a';
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	WeightedWordMapping() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] words1 = { "abcd", "def", "xyz" };
		final int[] weights1 = { 5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2 };
		assert "rij".equals(mapWordWeights(words1, weights1));

		final String[] words2 = { "a", "b", "c" };
		final int[] weights2 = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		assert "yyy".equals(mapWordWeights(words2, weights2));

		final String[] words3 = { "abcd" };
		final int[] weights3 = { 7, 5, 3, 4, 3, 5, 4, 9, 4, 2, 2, 7, 10, 2, 5, 10, 6, 1, 2, 2, 4, 1, 3, 4, 4, 5 };
		assert "g".equals(mapWordWeights(words3, weights3));
	}

	static String mapWordWeights(String[] words, int[] weights) {
		final int n = words.length;
		final char[] ans = new char[n];
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (char ch : words[i].toCharArray())
				sum = sum + weights[ch - FIRST_LETTER];

			ans[i] = ALPHABET.charAt(25 - sum % 26);
		}
		return new String(ans);
	}
}
