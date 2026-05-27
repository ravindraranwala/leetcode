package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.Map;

class CountTheNumberOfSpecialCharactersII {
	CountTheNumberOfSpecialCharactersII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert numberOfSpecialChars("aaAbcBC") == 3;
		assert numberOfSpecialChars("abc") == 0;
		assert numberOfSpecialChars("AbBCab") == 0;
	}

	static int numberOfSpecialChars(String word) {
		final int n = word.length();
		final Map<Character, Integer> lastLowerIdx = new HashMap<>();
		final Map<Character, Integer> firstUpperIdx = new HashMap<>();

		for (int i = 0; i < n; i++) {
			final char ch = word.charAt(i);
			if (Character.isLowerCase(ch))
				lastLowerIdx.put(ch, i);
			else if (!firstUpperIdx.containsKey(ch))
				firstUpperIdx.put(ch, i);
		}

		int cnt = 0;
		for (Map.Entry<Character, Integer> e : firstUpperIdx.entrySet()) {
			final char lowerCh = Character.toLowerCase(e.getKey());
			if (lastLowerIdx.containsKey(lowerCh) && lastLowerIdx.get(lowerCh) < e.getValue())
				cnt = cnt + 1;
		}
		return cnt;
	}
}
