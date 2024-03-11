package com.coding.challenge.sorting;

import java.util.HashMap;
import java.util.Map;

class CustomSortString {
	CustomSortString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		System.out.println(customSortString("cba", "abcd"));
		System.out.println(customSortString("bcafg", "abcd"));
	}

	static String customSortString(String order, String s) {
		final Map<Character, Integer> freq = new HashMap<>();
		for (char ch : s.toCharArray())
			freq.merge(ch, 1, Integer::sum);

		final char[] ans = new char[s.length()];
		int curr = 0;
		for (char ch : order.toCharArray()) {
			final int f = freq.getOrDefault(ch, 0);
			for (int j = 0; j < f; j++) {
				ans[curr] = ch;
				curr = curr + 1;
			}
			if (freq.containsKey(ch))
				freq.remove(ch);
		}

		for (char ch : freq.keySet()) {
			final int f = freq.get(ch);
			for (int j = 0; j < f; j++) {
				ans[curr] = ch;
				curr = curr + 1;
			}
		}
		return String.valueOf(ans);
	}
}
