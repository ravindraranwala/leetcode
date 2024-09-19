package com.coding.challenge.hash.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UncommonWordsFromTwoSentences {
	private static final char SPACE = ' ';

	UncommonWordsFromTwoSentences() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(uncommonFromSentences("this apple is sweet", "this apple is sour")));
		System.out.println(Arrays.toString(uncommonFromSentences("apple apple", "banana")));
	}

	static String[] uncommonFromSentences(String s1, String s2) {
		final Map<String, Integer> f = new HashMap<>();
		freqTable(s1, f);
		freqTable(s2, f);
		final List<String> l = new ArrayList<>();
		for (String s : f.keySet())
			if (f.get(s) == 1)
				l.add(s);

		return l.toArray(new String[0]);
	}

	private static void freqTable(String s, Map<String, Integer> f) {
		final int m = s.length();
		int i = 0;
		for (int j = 0; j < m; j++) {
			if (s.charAt(j) == SPACE) {
				f.merge(s.substring(i, j), 1, Integer::sum);
				i = j + 1;
			}
		}
		f.merge(s.substring(i, m), 1, Integer::sum);
	}
}
