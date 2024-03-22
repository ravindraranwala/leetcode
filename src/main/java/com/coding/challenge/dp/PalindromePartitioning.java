package com.coding.challenge.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class PalindromePartitioning {
	PalindromePartitioning() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final List<List<String>> l1 = Arrays.asList(Arrays.asList("a", "a", "b"), Arrays.asList("aa", "b"));
		assert l1.equals(partition("aab"));

		final List<List<String>> l2 = Arrays.asList(Arrays.asList("a"));
		assert l2.equals(partition("a"));
	}

	static List<List<String>> partition(String s) {
		final int n = s.length();
		final List<List<List<String>>> l = new ArrayList<>();
		for (int i = 0; i <= n; i++)
			l.add(new ArrayList<>());
		// trivial case of the recursion.
		l.get(n).add(Collections.emptyList());

		// topological order - solve using suffixes.
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (isPalindrome(s, i, j)) {
					final String p = s.substring(i, j + 1);
					for (List<String> sln : l.get(j + 1)) {
						final List<String> currSln = new ArrayList<>();
						currSln.add(p);
						currSln.addAll(sln);
						l.get(i).add(currSln);
					}
				}
			}
		}
		return l.get(0);
	}

	private static boolean isPalindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i = i + 1;
			j = j - 1;
		}
		return true;
	}
}
