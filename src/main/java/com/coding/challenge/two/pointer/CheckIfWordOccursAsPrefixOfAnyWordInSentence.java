package com.coding.challenge.two.pointer;

class CheckIfWordOccursAsPrefixOfAnyWordInSentence {

	CheckIfWordOccursAsPrefixOfAnyWordInSentence() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert isPrefixOfWord("i love eating burger", "burg") == 4;
		assert isPrefixOfWord("this problem is an easy problem", "pro") == 2;
		assert isPrefixOfWord("i am tired", "you") == -1;
	}

	static int isPrefixOfWord(String sentence, String searchWord) {
        final int m = sentence.length();
		final int n = searchWord.length();

		for (int i = 0, j = 0, k = 1, s = 0; i < m; i++) {
			if (i - s == j && sentence.charAt(i) == searchWord.charAt(j)) 
				j = j + 1;

			if (j == n)
				return k;
			if (sentence.charAt(i) == ' ') {
				j = 0;
				k = k + 1;
				s = i + 1;
			}
		}
		return -1;
	}
}
