package com.coding.challenge.greedy;

import java.util.ArrayList;
import java.util.List;

class LongestUnequalAdjacentGroupsSubsequenceI {
	LongestUnequalAdjacentGroupsSubsequenceI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] words1 = { "e", "a", "b" };
		final int[] groups1 = { 0, 0, 1 };
		System.out.println(getLongestSubsequence(words1, groups1));

		final String[] words2 = { "a", "b", "c", "d" };
		final int[] groups2 = { 1, 0, 1, 1 };
		System.out.println(getLongestSubsequence(words2, groups2));
	}

	static List<String> getLongestSubsequence(String[] words, int[] groups) {
		final int n = groups.length;
		final List<String> l = new ArrayList<>();
		l.add(words[0]);
		for (int i = 1; i < n; i++) 
			if (groups[i] != groups[i - 1])
				l.add(words[i]);
		
		return l;
	}
}
