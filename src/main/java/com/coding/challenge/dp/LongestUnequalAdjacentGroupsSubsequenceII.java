package com.coding.challenge.dp;

import java.util.ArrayList;
import java.util.List;

class LongestUnequalAdjacentGroupsSubsequenceII {
	LongestUnequalAdjacentGroupsSubsequenceII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] words1 = { "bab", "dab", "cab" };
		final int[] groups1 = { 1, 2, 2 };
		System.out.println(getWordsInLongestSubsequence(words1, groups1));

		final String[] words2 = { "a", "b", "c", "d" };
		final int[] groups2 = { 1, 2, 3, 4 };
		System.out.println(getWordsInLongestSubsequence(words2, groups2));
	}

	static List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
		final int n = words.length;
		final int[] l = new int[n];
		final int[] p = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			l[i] = 1;
			p[i] = -1;
			for (int j = i + 1; j < n; j++) {
				if (groups[i] != groups[j] && hamingDistance(words[i], words[j]) == 1 && l[j] >= l[i]) {
					l[i] = l[j] + 1;
					p[i] = j;
				}
			}
		}

		// find the starting index k of the max length subsequence.
		int k = 0;
		for (int i = 0; i < n; i++)
			if (l[i] > l[k])
				k = i;

		// constructing an optimal solution.
		final List<String> ans = new ArrayList<>();
		while (k != -1) {
			ans.add(words[k]);
			k = p[k];
		}
		return ans;
	}

	private static int hamingDistance(String s1, String s2) {
		if (s1.length() != s2.length())
			return Integer.MAX_VALUE;

		final int m = s1.length();
		int d = 0;
		for (int i = 0; i < m; i++)
			if (s1.charAt(i) != s2.charAt(i))
				d = d + 1;

		return d;
	}
}
