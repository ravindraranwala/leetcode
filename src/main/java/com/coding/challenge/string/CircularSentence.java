package com.coding.challenge.string;

class CircularSentence {
	CircularSentence() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert isCircularSentence("leetcode exercises sound delightful");
		assert isCircularSentence("eetcode");
		assert !isCircularSentence("Leetcode is cool");
	}

	static boolean isCircularSentence(String sentence) {
		final int n = sentence.length();
		for (int i = 0; i < n; i++)
			if (sentence.charAt(i) == ' ')
				if (sentence.charAt(i - 1) != sentence.charAt(i + 1))
					return false;

		return sentence.charAt(0) == sentence.charAt(n - 1);
	}
}
