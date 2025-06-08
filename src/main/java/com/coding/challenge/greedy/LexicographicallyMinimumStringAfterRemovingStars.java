package com.coding.challenge.greedy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class LexicographicallyMinimumStringAfterRemovingStars {
	private static final char FIRST_LETTER = 'a';

	LexicographicallyMinimumStringAfterRemovingStars() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "aab".equals(clearStars("aaba*"));
		assert "abc".equals(clearStars("abc"));
	}

	static String clearStars(String s) {
		final int n = s.length();
		final boolean[] d = new boolean[n];
		final List<Deque<Integer>> letterPositions = new ArrayList<>();
		for (int i = 0; i < 26; i++)
			letterPositions.add(new ArrayDeque<>());

		final Queue<Character> h = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			final char ch = s.charAt(i);
			if (ch == '*') {
				d[i] = true;
				final char letter = h.peek();
				final int j = letterPositions.get(letter - FIRST_LETTER).pop();
				d[j] = true;
				if (letterPositions.get(letter - FIRST_LETTER).isEmpty())
					h.remove();
			} else {
				if (letterPositions.get(ch - FIRST_LETTER).isEmpty())
					h.offer(ch);
				letterPositions.get(ch - FIRST_LETTER).push(i);
			}
		}

		final StringBuilder ans = new StringBuilder();
		for (int i = 0; i < n; i++)
			if (!d[i])
				ans.append(s.charAt(i));

		return ans.toString();
	}
}
