package com.coding.challenge.kadanes;

import java.util.HashMap;
import java.util.Map;

class FindTheSubstringWithMaximumCost {
	private static final char FIRST_LETTER = 'a';

	FindTheSubstringWithMaximumCost() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] vals1 = { -1000 };
		assert maximumCostSubstring("adaa", "d", vals1) == 2;

		final int[] vals2 = { -1, -1, -1 };
		assert maximumCostSubstring("abc", "abc", vals2) == 0;
	}

	static int maximumCostSubstring(String s, String chars, int[] vals) {
		final Map<Character, Integer> charToIdx = new HashMap<>();
		final int l = chars.length();
		for (int i = 0; i < l; i++)
			charToIdx.put(chars.charAt(i), i);

		int cost = 0;
		final int n = s.length();
		for (int i = 0, prevCost = 0; i < n; i++) {
			int letterCost = 0;
			final char ch = s.charAt(i);
			if (charToIdx.containsKey(ch))
				letterCost = vals[charToIdx.get(ch)];
			else
				letterCost = ch - FIRST_LETTER + 1;

			if (prevCost > 0)
				prevCost = prevCost + letterCost;
			else
				prevCost = letterCost;
			cost = Math.max(cost, prevCost);
		}
		return cost;
	}
}
