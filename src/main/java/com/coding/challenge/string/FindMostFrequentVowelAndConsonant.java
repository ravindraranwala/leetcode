package com.coding.challenge.string;

class FindMostFrequentVowelAndConsonant {
	private static final char FIRST_LETTER = 'a';

	FindMostFrequentVowelAndConsonant() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maxFreqSum("successes") == 6;
		assert maxFreqSum("aeiaeia") == 3;
	}

	static int maxFreqSum(String s) {
		final int[] f = new int[26];
		for (char ch : s.toCharArray())
			f[ch - FIRST_LETTER] = f[ch - FIRST_LETTER] + 1;

		int maxVowelFreq = 0;
		int maxConsonentFreq = 0;
		for (int i = 0; i < 26; i++) {
			if (i == 'a' - FIRST_LETTER || i == 'e' - FIRST_LETTER || i == 'i' - FIRST_LETTER || i == 'o' - FIRST_LETTER
					|| i == 'u' - FIRST_LETTER)
				maxVowelFreq = Math.max(maxVowelFreq, f[i]);
			else
				maxConsonentFreq = Math.max(maxConsonentFreq, f[i]);
		}
		return maxVowelFreq + maxConsonentFreq;
	}
}
