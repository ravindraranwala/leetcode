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
		// only upper case English letters are allowed.
		final int[] charFreq = new int[26];
		int l = 0;
		for (int j = 0, i = 0, maxFreq = 0; j < n; j++) {
			charFreq[s.charAt(j) - FIRST_LETTER] = charFreq[s.charAt(j) - FIRST_LETTER] + 1;
			// if there exists a more optimal solution, then it should have a higher max
			// frequency that what we have now.
			maxFreq = Math.max(maxFreq, charFreq[s.charAt(j) - FIRST_LETTER]);
			while (j - i + 1 - maxFreq > k) {
				// No need to update the max frequency as the window shrinks, as it only leads
				// to sub-optimal solutions.
				// Although we skip some of the subproblems, it's still ok as none of them lead
				// to an optimal
				// solution. Thus, it donesn't affect the correctness of our final solution.
				charFreq[s.charAt(i) - FIRST_LETTER] = charFreq[s.charAt(i) - FIRST_LETTER] - 1;
				i = i + 1;
			}
			l = Math.max(l, j - i + 1);
		}
		return l;
	}
}
