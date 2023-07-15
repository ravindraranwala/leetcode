package com.coding.challenge.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class SortCharactersByFrequency {
	SortCharactersByFrequency() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String strOne = "tree";
		System.out.println(frequencySort(strOne));

		final String strTwo = "cccaaa";
		System.out.println(frequencySort(strTwo));

		final String strThree = "Aabb";
		System.out.println(frequencySort(strThree));
	}

	static String frequencySort(String s) {
		final Map<Character, Integer> f = new HashMap<>();
		for (char ch : s.toCharArray())
			f.merge(ch, 1, Integer::sum);

		final List<Entry<Character, Integer>> l = new ArrayList<>(f.entrySet());
		Collections.sort(l, (a, b) -> Integer.compare(b.getValue(), a.getValue()));
		final StringBuilder sb = new StringBuilder();
		for (Entry<Character, Integer> e : l)
			for (int c = e.getValue(); c > 0; c--)
				sb.append(e.getKey());

		return sb.toString();
	}
}
