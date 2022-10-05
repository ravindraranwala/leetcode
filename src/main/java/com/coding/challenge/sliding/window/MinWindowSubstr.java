package com.coding.challenge.sliding.window;

import java.util.HashMap;
import java.util.Map;

class MinWindowSubstr {
	MinWindowSubstr() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "BANC".equals(minWindow("ADOBECODEBANC", "ABC"));

		assert "a".equals(minWindow("a", "a"));

		assert "".equals(minWindow("a", "aa"));

		assert "ba".equals(minWindow("bba", "ab"));

		assert "cwae".equals(minWindow("cabwefgewcwaefgcf", "cae"));
		
		assert "b".equals(minWindow("ab", "b"));
	}

	static String minWindow(String s, String t) {
		final int n = s.length();
		// use of auxiliary data structures
		final Map<Character, Integer> tm = new HashMap<>();
		final Map<Character, Integer> dm = new HashMap<>();

		// initializing tables
		for (char ch : t.toCharArray()) {
			tm.merge(ch, 1, Integer::sum);
			dm.merge(ch, 1, Integer::sum);
		}

		// window bounds
		int i = 0;
		int j = 0;
		final Map<Character, Integer> wm = new HashMap<>();
		// Finding the upper bound of the initial window.
		while (j < n && !dm.isEmpty()) {
			final char ch = s.charAt(j);
			if (tm.containsKey(ch)) {
				wm.merge(ch, 1, Integer::sum);
				if (dm.containsKey(ch)) {
					dm.put(ch, dm.get(ch) - 1);
					if (dm.get(ch) == 0)
						dm.remove(ch);
				}
			}
			j = j + 1;
		}

		// no such substring.
		if (!dm.isEmpty())
			return "";

		// Finding the lower bound of the initial window.
		while (i < n && !tm.containsKey(s.charAt(i)))
			i = i + 1;
		
		// sliding the window
		for (int k = i, l = j, lb = i; wm.get(s.charAt(lb)) >= tm.get(s.charAt(lb)); k++) {
			if (tm.containsKey(s.charAt(k))) {
				if (j - i > l - k) {
					i = k;
					j = l;
				}
				lb = k;
				wm.put(s.charAt(k), wm.get(s.charAt(k)) - 1);
				while (l < n && wm.get(s.charAt(k)) < tm.get(s.charAt(k))) {
					if (tm.containsKey(s.charAt(l)))
						wm.put(s.charAt(l), wm.get(s.charAt(l)) + 1);
					l = l + 1;
				}
			}
		}
		return s.substring(i, j);
	}
}
