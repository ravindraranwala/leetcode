package com.coding.challenge.backtracking;

import java.util.ArrayList;
import java.util.List;

class LetterCombinationsOfPhoneNumber {
	private final List<String> l = new ArrayList<>();
	private static final char[][] numberToLetter = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' },
			{ 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
	private static final char ZERO = '0';

	LetterCombinationsOfPhoneNumber() {

	}

	public static void main(String[] args) {
		System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations("23"));
		System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations(""));
		System.out.println(new LetterCombinationsOfPhoneNumber().letterCombinations("2"));
	}

	List<String> letterCombinations(String digits) {
		if (digits.isEmpty())
			return l;
		backtrack(digits, 0, new char[digits.length()]);
		return l;
	}

	private void backtrack(String digits, int i, char[] cmb) {
		if (i == digits.length()) {
			l.add(String.valueOf(cmb));
			return;
		}

		for (char ch : numberToLetter[digits.charAt(i) - ZERO - 2]) {
			// unchoose and then choose.
			cmb[i] = ch;
			// explore.
			backtrack(digits, i + 1, cmb);
		}
	}
}
