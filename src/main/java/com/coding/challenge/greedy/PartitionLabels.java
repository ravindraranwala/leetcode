package com.coding.challenge.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class PartitionLabels {
	private static final char FIRST_LETTER = 'a';

	PartitionLabels() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String s1 = "ababcbacadefegdehijhklij";
		assert Arrays.asList(9, 7, 8).equals(partitionLabels(s1));

		final String s2 = "eccbbbbdec";
		assert Arrays.asList(10).equals(partitionLabels(s2));
	}

	static List<Integer> partitionLabels(String s) {
		final int n = s.length();
		final int[] charFreq = new int[26];
		for (char ch : s.toCharArray())
			charFreq[ch - FIRST_LETTER] = charFreq[ch - FIRST_LETTER] + 1;

		final List<Integer> ans = new ArrayList<>();
		final Set<Character> window = new HashSet<>();
		for (int i = 0, j = 0, ties = 0; j < n; j++) {
			window.add(s.charAt(j));
			charFreq[s.charAt(j) - FIRST_LETTER] = charFreq[s.charAt(j) - FIRST_LETTER] - 1;
			if (charFreq[s.charAt(j) - FIRST_LETTER] == 0)
				ties = ties + 1;

			if (window.size() == ties) {
				ans.add(j - i + 1);
				i = j + 1;
			}
		}

		return ans;
	}
}
