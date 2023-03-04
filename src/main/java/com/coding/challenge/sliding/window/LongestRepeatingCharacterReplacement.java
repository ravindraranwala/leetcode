package com.coding.challenge.sliding.window;

class LongestRepeatingCharacterReplacement {
	private static final char FIRST_LETTER = 'A';

	LongestRepeatingCharacterReplacement() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String s1 = "ABAB";
		assert characterReplacement(s1, 2) == 4;

		final String s2 = "AABABBA";
		assert characterReplacement(s2, 1) == 4;

		final String s3 = "AAAA";
		assert characterReplacement(s3, 2) == 4;

		final String s4 = "KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF";
		assert characterReplacement(s4, 4) == 7;
	}

	static int characterReplacement(String s, int k) {
		final int n = s.length();
		// only upper case english letters are allowed.
		final int[] charFreq = new int[26];
		int l = 0;
		for (int j = 0, i = 0; j < n; j++) {
			charFreq[s.charAt(j) - FIRST_LETTER] = charFreq[s.charAt(j) - FIRST_LETTER] + 1;
			while (j - i + 1 - largest(charFreq) > k) {
				charFreq[s.charAt(i) - FIRST_LETTER] = charFreq[s.charAt(i) - FIRST_LETTER] - 1;
				i = i + 1;
			}
			l = Math.max(l, j - i + 1);
		}
		return l;
	}

	private static int largest(int[] a) {
		int maxVal = 0;
		for (int i = 0; i < 26; i++)
			maxVal = Math.max(maxVal, a[i]);
		return maxVal;
	}

}
