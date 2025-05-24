package com.coding.challenge.string;

import java.util.ArrayList;
import java.util.List;

class FindWordsContainingCharacter {
	FindWordsContainingCharacter() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] words1 = { "leet", "code" };
		System.out.println(findWordsContaining(words1, 'e'));

		final String[] words2 = { "abc", "bcd", "aaaa", "cbc" };
		System.out.println(findWordsContaining(words2, 'a'));

		final String[] words3 = { "abc", "bcd", "aaaa", "cbc" };
		System.out.println(findWordsContaining(words3, 'z'));
	}

	static List<Integer> findWordsContaining(String[] words, char x) {
		final int n = words.length;
		final List<Integer> l = new ArrayList<>();
		for (int i = 0; i < n; i++) 
			if (contains(words[i], x))
				l.add(i);
		
		return l;
	}
	
	private static boolean contains(String word, char x) {
		for (char ch : word.toCharArray())
			if (ch == x)
				return true;
		
		return false;
	}
}
