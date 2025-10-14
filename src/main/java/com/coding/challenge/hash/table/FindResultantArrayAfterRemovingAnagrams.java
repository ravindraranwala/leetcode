package com.coding.challenge.hash.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindResultantArrayAfterRemovingAnagrams {
	private static final char FIRST_LETTER = 'a';

	FindResultantArrayAfterRemovingAnagrams() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] words1 = { "abba", "baba", "bbaa", "cd", "cd" };
		final List<String> ans1 = Arrays.asList("abba", "cd");
		assert ans1.equals(removeAnagrams(words1));

		final String[] words2 = { "a", "b", "c", "d", "e" };
		final List<String> ans2 = Arrays.asList("a", "b", "c", "d", "e");
		assert ans2.equals(removeAnagrams(words2));
	}

	static List<String> removeAnagrams(String[] words) {
		final int n = words.length;
		int[] prevFreq = new int[26];
		final List<String> ans = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			final int[] currFreq = new int[26];
			final String currWord = words[i];
			for (char ch : currWord.toCharArray())
				currFreq[ch - FIRST_LETTER] = currFreq[ch - FIRST_LETTER] + 1;

			boolean anagram = true;
			for (int j = 0; j < 26; j++)
				if (currFreq[j] != prevFreq[j])
					anagram = false;

			if (!anagram) {
				ans.add(currWord);
				prevFreq = currFreq;
			}
		}
		return ans;
	}
}
