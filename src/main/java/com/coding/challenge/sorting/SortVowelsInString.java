package com.coding.challenge.sorting;

class SortVowelsInString {
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	SortVowelsInString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "lEOtcede".equals(sortVowels("lEetcOde"));
		assert "lYmpH".equals(sortVowels("lYmpH"));
	}

	static String sortVowels(String s) {
		// init.
		final int[] upperVowelFreq = new int[26];
		final int[] lowerVowelFreq = new int[26];
		for (char ch : s.toCharArray()) {
			final char lowerCh = Character.toLowerCase(ch);
			if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
				if (ch >= 'a')
					lowerVowelFreq[ch - ALPHABET.charAt(0)] = lowerVowelFreq[ch - ALPHABET.charAt(0)] + 1;
				else
					upperVowelFreq[lowerCh - ALPHABET.charAt(0)] = upperVowelFreq[lowerCh - ALPHABET.charAt(0)] + 1;
			}
		}

		final int n = s.length();
		final char[] ans = new char[n];
		int j = 0;
		while (j < 26 && upperVowelFreq[j] == 0)
			j = j + 1;

		int k = 0;
		while (k < 26 && lowerVowelFreq[k] == 0)
			k = k + 1;

		for (int i = 0; i < n; i++) {
			final char ch = s.charAt(i);
			final char lowerCh = Character.toLowerCase(ch);
			if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
				if (j < 26) {
					ans[i] = Character.toUpperCase(ALPHABET.charAt(j));
					// consume the letter.
					upperVowelFreq[j] = upperVowelFreq[j] - 1;
					// move to the next available letter.
					while (j < 26 && upperVowelFreq[j] == 0)
						j = j + 1;
				} else {
					ans[i] = ALPHABET.charAt(k);
					lowerVowelFreq[k] = lowerVowelFreq[k] - 1;
					while (k < 26 && lowerVowelFreq[k] == 0)
						k = k + 1;
				}
			} else
				ans[i] = ch;
		}
		return new String(ans);
	}
}
