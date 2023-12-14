package com.coding.challenge.binary.search;

import com.coding.challenge.BinarySearch;

class NumberOfMatchingSubsequences {
	private static final char FIRST_LETTER = 'a';

	NumberOfMatchingSubsequences() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] w1 = { "a", "bb", "acd", "ace" };
		assert numMatchingSubseq("abcde", w1) == 3;

		final String[] w2 = { "ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax" };
		assert numMatchingSubseq("dsahjpjauf", w2) == 2;

		final String[] w3 = { "wpddkvbnn", "lnagtva", "kvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvju",
				"rwpddkvbnnugln", "gloeofnpjqlkdsqvruvabjrikfwronbrdyyj",
				"vbgeinupkvgmgxeaaiuiyojmoqkahwvbpwugdainxciedbdkos",
				"mspuhbykmmumtveoighlcgpcapzczomshiblnvhjzqjlfkpina",
				"rgmliajkiknongrofpugfgajedxicdhxinzjakwnifvxwlokip",
				"fhepktaipapyrbylskxddypwmuuxyoivcewzrdwwlrlhqwzikq",
				"qatithxifaaiwyszlkgoljzkkweqkjjzvymedvclfxwcezqebx" };
		assert numMatchingSubseq(
				"rwpddkvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvjubjgloeofnpjqlkdsqvruvabjrikfwronbrdyyjnakstqjac",
				w3) == 5;
	}

	static int numMatchingSubseq(String s, String[] words) {
		final int[] f = new int[26];
		for (char ch : s.toCharArray())
			f[ch - FIRST_LETTER] = f[ch - FIRST_LETTER] + 1;

		final int[][] t = new int[26][];
		for (int i = 0; i < 26; i++)
			t[i] = new int[f[i]];

		final int[] p = new int[26];
		final int n = s.length();
		for (int i = 0; i < n; i++) {
			final int offset = s.charAt(i) - FIRST_LETTER;
			t[offset][p[offset]] = i;
			p[offset] = p[offset] + 1;
		}

		int c = 0;
		for (String w : words) {
			int sIdx = -1;
			boolean subSeq = true;
			for (char ch : w.toCharArray()) {
				final int k = BinarySearch.successor(t[ch - FIRST_LETTER], sIdx);
				// check whether successor exists.
				subSeq = subSeq && k < t[ch - FIRST_LETTER].length;
				if (!subSeq)
					break;
				sIdx = t[ch - FIRST_LETTER][k];
			}
			if (subSeq)
				c = c + 1;
		}
		return c;
	}
}
