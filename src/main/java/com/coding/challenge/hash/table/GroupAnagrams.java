package com.coding.challenge.hash.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagrams {
	private static final char FIRST_LETTER = 'a';

	GroupAnagrams() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] strsOne = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(groupAnagrams(strsOne));

		final String[] strsTwo = { "" };
		System.out.println(groupAnagrams(strsTwo));

		final String[] strsThree = { "a" };
		System.out.println(groupAnagrams(strsThree));
	}

	static List<List<String>> groupAnagrams(String[] strs) {
		final Map<List<Integer>, List<String>> t = new HashMap<>();
		for (String string : strs) {
			final List<Integer> f = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0);
			for (char ch : string.toCharArray())
				f.set(ch - FIRST_LETTER, f.get(ch - FIRST_LETTER) + 1);

			t.computeIfAbsent(f, unused -> new ArrayList<>()).add(string);
		}
		return new ArrayList<>(t.values());
	}
}
