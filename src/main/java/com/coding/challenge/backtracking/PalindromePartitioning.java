package com.coding.challenge.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
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
		final List<List<String>> l = new ArrayList<>();
		backtrack(l, s, 0, new ArrayList<>());
		return l;
	}

	private static void backtrack(List<List<String>> l, String s, int i, List<String> curr) {
		final int n = s.length();
		if (i == n) {
			l.add(new ArrayList<>(curr));
			return;
		}

		for (int j = i; j < n; j++) {
			if (isPalindrome(s, i, j)) {
				// choose.
				curr.add(s.substring(i, j + 1));
				// explore.
				backtrack(l, s, j + 1, curr);
				// unchoose.
				curr.remove(curr.size() - 1);
			}
		}
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
