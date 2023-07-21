package com.coding.challenge.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class LongestIdealSubsequence {
	LongestIdealSubsequence() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert longestIdealString("acfgbd", 2) == 4;
		assert longestIdealString("abcd", 3) == 4;
	}

	static int longestIdealString(String s, int k) {
		final Map<Character, Integer> t = new HashMap<>();
		int l = 0;
		for (char ch : s.toCharArray()) {
			int maxLen = 1;
			for (Entry<Character, Integer> e : t.entrySet())
				if (Math.abs(e.getKey() - ch) <= k)
					maxLen = Math.max(maxLen, e.getValue() + 1);

			t.merge(ch, maxLen, Integer::max);
			l = Math.max(l, maxLen);
		}
		return l;
	}
}
