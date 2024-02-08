package com.coding.challenge.backtracking;

import java.util.ArrayList;
import java.util.List;

class LetterCasePermutation {
	private final List<String> l = new ArrayList<>();

	LetterCasePermutation() {
	}

	public static void main(String[] args) {
		System.out.println(new LetterCasePermutation().letterCasePermutation("a1b2"));
		System.out.println(new LetterCasePermutation().letterCasePermutation("3z4"));
	}

	List<String> letterCasePermutation(String s) {
		final char[] perm = new char[s.length()];
		backtrack(s, 0, perm);
		return l;
	}

	private void backtrack(String s, int i, char[] perm) {
		if (i == s.length()) {
			l.add(new String(perm));
			return;
		}
		// unchoose and then choose
		final char ch = s.charAt(i);
		perm[i] = ch;
		// explore.
		backtrack(s, i + 1, perm);

		if (Character.isLetter(ch)) {
			// switch the case and explore.
			if (Character.isLowerCase(ch))
				// unchoose and then choose
				perm[i] = Character.toUpperCase(ch);
			else
				// unchoose and then choose
				perm[i] = Character.toLowerCase(ch);
			// explore.
			backtrack(s, i + 1, perm);
		}
	}
}
