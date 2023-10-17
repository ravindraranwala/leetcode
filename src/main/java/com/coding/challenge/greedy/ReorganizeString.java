package com.coding.challenge.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

class ReorganizeString {
	private static final char FIRST_LETTER = 'a';

	ReorganizeString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "aba".equals(reorganizeString("aab"));
		assert "".equals(reorganizeString("aaab"));
		assert "vlvov".equals(reorganizeString("vvvlo"));
	}

	static String reorganizeString(String s) {
		final int[] f = new int[26];
		for (char ch : s.toCharArray())
			f[ch - FIRST_LETTER] = f[ch - FIRST_LETTER] + 1;

		final Queue<Integer> h = new PriorityQueue<>((i, j) -> Integer.compare(f[j], f[i]));
		for (int i = 0; i < 26; i++)
			if (f[i] > 0)
				h.add(i);

		final StringBuilder sb = new StringBuilder();
		while (h.size() > 1) {
			final int p = h.remove();
			final int q = h.remove();
			sb.append(Character.toChars(FIRST_LETTER + p));
			sb.append(Character.toChars(FIRST_LETTER + q));
			f[p] = f[p] - 1;
			f[q] = f[q] - 1;
			if (f[p] > 0)
				h.add(p);

			if (f[q] > 0)
				h.add(q);
		}
		if (h.size() == 1) {
			final int k = h.remove();
			if (f[k] == 1)
				sb.append(Character.toChars(FIRST_LETTER + k));
			else
				return "";

		}
		return sb.toString();
	}
}
