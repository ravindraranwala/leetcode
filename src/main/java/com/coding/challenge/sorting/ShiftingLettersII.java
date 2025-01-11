package com.coding.challenge.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

class ShiftingLettersII {
	private static final char FIRST_LETTER = 'a';

	ShiftingLettersII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] shifts1 = { { 0, 1, 0 }, { 1, 2, 1 }, { 0, 2, 1 } };
		assert "ace".equals(shiftingLetters("abc", shifts1));

		final int[][] shifts2 = { { 0, 0, 0 }, { 1, 1, 1 } };
		assert "catz".equals(shiftingLetters("dztz", shifts2));

		final int[][] shifts3 = { { 4, 8, 0 }, { 4, 4, 0 }, { 2, 4, 0 }, { 2, 4, 0 }, { 6, 7, 1 }, { 2, 2, 1 },
				{ 0, 2, 1 }, { 8, 8, 0 }, { 1, 3, 1 } };
		assert "ywxcxcqii".equals(shiftingLetters("xuwdbdqik", shifts3));
	}

	static String shiftingLetters(String s, int[][] shifts) {
		Arrays.sort(shifts, (a1, a2) -> Integer.compare(a1[0], a2[0]));
		final int n = s.length();
		final int m = shifts.length;
		final char[] ans = new char[n];
		final PriorityQueue<int[]> h = new PriorityQueue<int[]>((a1, a2) -> Integer.compare(a1[1], a2[1]));
		for (int i = 0, j = 0, offset = 0; i < n; i++) {
			while (j < m && shifts[j][0] <= i) {
				if (shifts[j][2] == 1)
					offset = offset + 1;
				else
					offset = offset - 1;
				h.add(shifts[j]);
				j = j + 1;
			}

			while (!h.isEmpty() && h.peek()[1] < i) {
				final int[] f = h.remove();
				// cancel out the effect of the current shift which finishes before i.
				if (f[2] == 1)
					offset = offset - 1;
				else
					offset = offset + 1;
			}
			final int shiftCnt = offset % 26;
			ans[i] = (char) (FIRST_LETTER + ((s.charAt(i) - FIRST_LETTER + shiftCnt + 26) % 26));
		}
		return new String(ans);
	}
}
